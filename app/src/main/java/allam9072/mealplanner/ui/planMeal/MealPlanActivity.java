package allam9072.mealplanner.ui.planMeal;

import android.content.DialogInterface;
import android.content.Intent;
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
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import allam9072.mealplanner.DB.m_Tables.MealEntity;
import allam9072.mealplanner.DB.m_Tables.MealProductXRefEntity;
import allam9072.mealplanner.DB.m_Tables.ProductEntity;
import allam9072.mealplanner.R;
import allam9072.mealplanner.ui.planDay.DayPlanActivity;


public class MealPlanActivity extends AppCompatActivity implements MealPlanAdapter.click_interface {
    private RecyclerView rv_products, rv_selected_products;
    private ArrayList<ProductEntity> SelectedProductsList = new ArrayList<>();
    private MealPlanAdapter MainAdapter;
    private MealPlanNestedAdapter NestedAdapter;
    private MealPlanViewModel viewModel;
    private String mealTitle;
    private int MealId;
    private int product_id_catch;
    private String list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan);
        // getIntentFormParent();
        open_intent_from_meal_item_rv();
        init();

        viewModel = new ViewModelProvider(this).get(MealPlanViewModel.class);
        viewModel.getAllProducts().observe(this, new Observer<List<ProductEntity>>() {
            @Override
            public void onChanged(List<ProductEntity> products) {
                MainAdapter.setProducts(products);
            }
        });
    }

    private void init() {
        getSupportActionBar().setHomeButtonEnabled(true);
        // rv_products
        rv_products = findViewById(R.id.rv_meal_products);
        rv_products.setLayoutManager(new StaggeredGridLayoutManager(6, 0));
        MainAdapter = new MealPlanAdapter(this);
        rv_products.setAdapter(MainAdapter);
        // rv_selected_products
        rv_selected_products = findViewById(R.id.rv_selected_products);
        rv_selected_products.setLayoutManager(new GridLayoutManager(this, 3));
        NestedAdapter = new MealPlanNestedAdapter(getApplicationContext(), SelectedProductsList);
        rv_selected_products.setAdapter(NestedAdapter);
        // add new product
        FloatingActionButton btnAddProduct = findViewById(R.id.btn_add_product);
        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProductManually();
            }
        });
    }

    private void open_intent_from_meal_item_rv() {
        Intent intent = getIntent();
        MealId = intent.getIntExtra("mealId", 0);
        String day_name = intent.getStringExtra("mealName");
        SelectedProductsList = intent.getParcelableArrayListExtra("arrayList");
        Toast.makeText(this, MealId + " " + day_name + " " + "\n", Toast.LENGTH_SHORT).show();
    }

    //    private void getIntentFormParent() {
//        Intent Received_intent = getIntent();
//        if (Received_intent.hasExtra("meal_id")) {
//            mealTitle = Received_intent.getStringExtra("mealTitle");
//            setTitle(mealTitle);
//            receivedMealId = Received_intent.getIntExtra("meal_id", -1);
//        } else {
//            setTitle(mealTitle);
//        }
//        if (Received_intent.hasExtra("RPList")) {
//            selectedProductsList = Received_intent.getParcelableArrayListExtra("RPList");
//        }
//
//    }
    private void SaveMeal() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_meal_done, null);
        TextView textView = view.findViewById(R.id.tv_dialog_meal_done);
        if (getTitle() == null) {
            Toast.makeText(this, "enter meal Title", Toast.LENGTH_SHORT).show();
        } else {
            list = getSupportActionBar().getTitle().toString() + "\n";
        }

        for (int i = 0; i < SelectedProductsList.size(); i++) {
            list += SelectedProductsList.get(i).getProduct_name() + "\t\t";
        }
        textView.setText(list);
        builder.setView(view)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent resultsIntent = new Intent(getApplicationContext(), DayPlanActivity.class);
                        resultsIntent.putExtra("mealTitle", mealTitle);
                        resultsIntent.putParcelableArrayListExtra("PList", SelectedProductsList);
                        viewModel.insert_meal(new MealEntity(getTitle().toString(), getTitle().toString()));
                        setResult(RESULT_OK, resultsIntent);
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
                .setTitle("Edit meal Title")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setTitle(editText.getText().toString());
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
                        viewModel.insert_product(product_main);
//                        selectedProductsList.add(e_product_main);
//                        rv_selected_products.setAdapter(mealPlanNestedAdapter);
                        product_id_catch = product_main.getProductId();
                        //    Toast.makeText(MealPlanActivity.this, String.valueOf(receivedMealId) + " " + product_id_catch, Toast.LENGTH_SHORT).show();


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
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void click(int position) {
        int ProductId = viewModel.getAllProducts().getValue().get(position).getProductId();
        if (viewModel.getAllProducts().getValue().get(position).equals(SelectedProductsList.get(position))) {
            viewModel.getAllProducts().getValue().remove(position);
            return;
        } else {
            SelectedProductsList.add(viewModel.getAllProducts().getValue().get(position));
            viewModel.insert_meal_product(new MealProductXRefEntity(MealId, ProductId));
            rv_selected_products.setAdapter(NestedAdapter);
        }


    }


}
