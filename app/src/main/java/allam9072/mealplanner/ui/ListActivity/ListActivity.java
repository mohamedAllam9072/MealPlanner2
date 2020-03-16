package allam9072.mealplanner.ui.ListActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import allam9072.mealplanner.DB.Category;
import allam9072.mealplanner.DB.JsonAPI;
import allam9072.mealplanner.DB.Product;
import allam9072.mealplanner.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListActivity extends AppCompatActivity {
    ListAdapter listAdapter;
    private RecyclerView rv;
    String categoryTitle;
    int category_id, x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_arrow);


        Intent intent = getIntent();
        categoryTitle = intent.getStringExtra("cat_title");
        category_id = intent.getIntExtra("cat_id", 1);
        x = category_id - 1;

        rv = findViewById(R.id.rv_2);
        rv.setLayoutManager(new GridLayoutManager(this, 2));
        retrofit();


    }


    private void retrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://5bcce576cf2e850013874767.mockapi.io/task/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonAPI jsonAPI = retrofit.create(JsonAPI.class);
        Call<List<Category>> call = jsonAPI.getAllCategories();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                List<Category> categories = response.body();

                List<Product> productList = categories.get(x).getProducts();
                rv.setAdapter(new ListAdapter(getApplicationContext(), productList));
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Toast.makeText(ListActivity.this, "fail", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
