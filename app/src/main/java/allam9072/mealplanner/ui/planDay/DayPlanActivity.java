package allam9072.mealplanner.ui.planDay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import allam9072.mealplanner.DB.m_Tables.MealEntity;
import allam9072.mealplanner.DB.m_Tables.ProductEntity;
import allam9072.mealplanner.R;
import allam9072.mealplanner.ui.planMeal.MealPlanActivity;

public class DayPlanActivity extends AppCompatActivity {
    private DayPlanAdapter adapter = new DayPlanAdapter();
    private DayPlanViewModel viewModel;
    private RecyclerView recyclerView;
    private ArrayList<ProductEntity> received_productList;
    private int receivedDayId;
    private static final int REQUEST_CODE_INSERT = 1;
    private static final int REQUEST_CODE_UPDATE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_plan);
        init();
        viewModel = new ViewModelProvider(this).get(DayPlanViewModel.class);
        viewModel.getAllMeals().observe(this, new Observer<List<MealEntity>>() {
            @Override
            public void onChanged(List<MealEntity> MealEntities) {
                adapter.setMeals(MealEntities);
            }
        });
//        viewModel.getAllProductsWithMeal().observe(this, new Observer<List<r_productsWithMeal>>() {
//            @Override
//            public void onChanged(List<r_productsWithMeal> r_productsWithMeals) {
//                adapter.setProductsWithMeals(r_productsWithMeals);
//            }
//        });
        adapter.setListener(new DayPlanAdapter.listener() {
            @Override
            public void click(MealEntity meal) {
                Intent intent = new Intent(getApplicationContext(), MealPlanActivity.class);
                if (received_productList != null) {
                    intent.putExtra("mealTitle", meal.getMeal_name());
                    intent.putExtra("meal_id", meal.getMealId());
                    intent.putParcelableArrayListExtra("RPList", received_productList);
                    Toast.makeText(DayPlanActivity.this, "RPList sent", Toast.LENGTH_SHORT).show();
                } else {
                    intent.putExtra("mealTitle", meal.getMeal_name());
                    intent.putExtra("meal_id", meal.getMealId());
                }
                startActivityForResult(intent, REQUEST_CODE_INSERT);
            }
        });

//        adapter.setOnClickItem2(new DayPlanAdapter.listener() {
//            @Override
//            public void click(r_productsWithMeal productsWithMeal) {
//                Intent intent = new Intent(getApplicationContext(), MealPlanActivity.class);
//                if (received_productList != null) {
//                    intent.putExtra("mealTitle", productsWithMeal.e_meal.getMeal_name());
//                    intent.putExtra("meal_id", productsWithMeal.e_meal.get_id_meal());
//                    intent.putParcelableArrayListExtra("RPList", received_productList);
//                    Toast.makeText(DayPlanActivity.this, "RPList sent", Toast.LENGTH_SHORT).show();
//                } else {
//                    intent.putExtra("mealTitle", productsWithMeal.e_meal.getMeal_name());
//                    intent.putExtra("meal_id", productsWithMeal.e_meal.get_id_meal());
//                }
//                startActivityForResult(intent, REQUEST_CODE_INSERT);
//            }
//        });
//        adapter.setOnClickItem2(new DayPlanAdapter.listener() {
//            @Override
//            public void click(e_meal meal) {
//                Intent intent = new Intent(getApplicationContext(), MealPlanActivity.class);
//                if (received_productList != null) {
//                    intent.putExtra("mealTitle", meal.getMeal_name());
//                    intent.putExtra("meal_id", meal.get_id_meal());
//                    intent.putParcelableArrayListExtra("RPList", received_productList);
//                    Toast.makeText(DayPlanActivity.this, "RPList sent", Toast.LENGTH_SHORT).show();
//                } else {
//                    intent.putExtra("mealTitle", meal.getMeal_name());
//                    intent.putExtra("meal_id", meal.get_id_meal());
//                }
//                startActivityForResult(intent, REQUEST_CODE_INSERT);
//            }
//        });


    }

    private void init() {
        Intent intent = getIntent();
        getSupportActionBar().setTitle(intent.getStringExtra("dayTitle"));
        receivedDayId = intent.getIntExtra("day_id", 0);

        recyclerView = findViewById(R.id.rv_create_meal);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        Button btn_add_new_meal = findViewById(R.id.btn_add_new_meal);
        btn_add_new_meal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MealPlanActivity.class);
                startActivityForResult(intent, REQUEST_CODE_INSERT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_INSERT && resultCode == RESULT_OK) {
            String mealTitle = data.getStringExtra("mealTitle");
            received_productList = data.getParcelableArrayListExtra("PList");
            String listString = "";
            for (int i = 0; i < received_productList.size(); i++) {
                listString += received_productList.get(i).getProduct_name();
            }
            viewModel.InsertMeal(new MealEntity(mealTitle, listString));
            Toast.makeText(this, mealTitle + " - " + listString, Toast.LENGTH_SHORT).show();


        } else if (requestCode == REQUEST_CODE_UPDATE && requestCode == RESULT_OK) {

        } else if (requestCode == REQUEST_CODE_INSERT && resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "no data ", Toast.LENGTH_SHORT).show();
        }
    }


}

