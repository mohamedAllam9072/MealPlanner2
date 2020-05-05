package allam9072.mealplanner.ui.planMeal;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import allam9072.mealplanner.DB.m_Tables.MealEntity;
import allam9072.mealplanner.DB.m_Tables.MealProductXRefEntity;
import allam9072.mealplanner.DB.m_Tables.MealProductsRelation;
import allam9072.mealplanner.DB.m_Tables.ProductEntity;
import allam9072.mealplanner.R;
import allam9072.mealplanner.ui.planWeek.WeekActivity;

import static allam9072.mealplanner.ui.planMeal.MealPlanAdapter.mOnClickListener;
import static allam9072.mealplanner.ui.planMeal.MealPlanNestedAdapter.deleteListener;


public class MealPlanActivity extends AppCompatActivity implements mOnClickListener, deleteListener {
    private RecyclerView rv_products, rv_selected_products;
    private MealPlanAdapter MainAdapter;
    private MealPlanNestedAdapter NestedAdapter;
    private MealPlanViewModel viewModel;
    private int mealId;
    private String mealTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan);

        init();

        viewModel.getAllProducts().observe(this, new Observer<List<ProductEntity>>() {
            @Override
            public void onChanged(List<ProductEntity> products) {
                MainAdapter.setProducts(products);
            }
        });
        viewModel.getNew_mealProducts(mealId).observe(this, new Observer<List<MealProductsRelation>>() {
            @Override
            public void onChanged(List<MealProductsRelation> mealProductsRelations) {
                NestedAdapter.setMealProductsList(mealProductsRelations.get(0).products);
                mealTitle = mealProductsRelations.get(0).meal.getMeal_name();
                getSupportActionBar().setTitle(mealTitle);
            }
        });


    }

    private void init() {
        //view model
        viewModel = ViewModelProviders.of(this).get(MealPlanViewModel.class);
        //xmlViews
        getSupportActionBar().setHomeButtonEnabled(true);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.set1_1)));
        rv_products = findViewById(R.id.rv_meal_products);
        rv_selected_products = findViewById(R.id.rv_selected_products);

        // getIntentFormParent();
        Intent intent = getIntent();
        mealId = intent.getIntExtra("mealId", 1);
        // rv_products
        rv_products.setLayoutManager(new GridLayoutManager(this, 2));
        MainAdapter = new MealPlanAdapter(this);
        rv_products.setAdapter(MainAdapter);
        // rv_selected_products
        rv_selected_products.setLayoutManager(new GridLayoutManager(this, 3));
        NestedAdapter = new MealPlanNestedAdapter(getApplicationContext(), this);
        rv_selected_products.setAdapter(NestedAdapter);
    }

    private void SaveMeal() {
        String list = " ";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_meal_done, null);
        TextView textView = view.findViewById(R.id.tv_dialog_meal_done);
        if (getTitle() == null) {
            setMealTitle();
        }
        textView.setText(list);
        builder.setView(view)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        viewModel.InsertMeal(new MealEntity(mealTitle, getTitle().toString()));
                        Intent intent = new Intent(getApplicationContext(), WeekActivity.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .create()
                .show();

    }

    private void setMealTitle() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_meal_title, null);
        final TextInputEditText editText = view.findViewById(R.id.editText_mealTitle);
        builder.setView(view)
                .setTitle(mealTitle)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getSupportActionBar().setTitle(editText.getText().toString());
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MealPlanActivity.this, "no", Toast.LENGTH_SHORT).show();
                    }
                })
                .create()
                .show();

    }

    private void addProductManually() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_meal_title, null);
        final TextInputEditText editText = view.findViewById(R.id.editText_mealTitle);
        builder.setView(view)
                .setTitle("add product")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String s = editText.getText().toString();
                        //Todo : edit e_product(s,10,10) with real values
                        ProductEntity product_main = new ProductEntity(s, 10, 10);
                        viewModel.InsertProduct(product_main);
//                        selectedProductsList.add(e_product_main);
//                        rv_selected_products.setAdapter(mealPlanNestedAdapter);
//                        product_id_catch = product_main.getProductId();
//                        Toast.makeText(MealPlanActivity.this, String.valueOf(receivedMealId) + " " + product_id_catch, Toast.LENGTH_SHORT).show();


                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MealPlanActivity.this, "no", Toast.LENGTH_SHORT).show();
                    }
                })
                .create()
                .show();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_meal_plan_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_meal:
                SaveMeal();
                break;
            case R.id.edit_meal_title:
                setMealTitle();
                break;
            case R.id.add_new_product:
                addProductManually();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void click(int position) {
        MealProductXRefEntity mealProductXRefEntity =
                new MealProductXRefEntity(mealId, viewModel.getAllProducts().getValue().get(position).getProductId());
        viewModel.InsertMealProduct(mealProductXRefEntity);

    }


    @Override
    public void delete_click(int position) {
        Toast.makeText(this, "delete ", Toast.LENGTH_SHORT).show();
        viewModel.deleteMealProduct(
                new MealProductXRefEntity(mealId, viewModel.getAllProducts().getValue().get(position).getProductId()));


    }
}
