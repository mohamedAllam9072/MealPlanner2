package allam9072.mealplanner.ui.market;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import allam9072.mealplanner.DB.market.Category_market;
import allam9072.mealplanner.DB.market.Client_api;
import allam9072.mealplanner.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MarketActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Category_market> categoryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        recyclerView = findViewById(R.id.rv_market);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        retrofit();
    }

    private void retrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://5bcce576cf2e850013874767.mockapi.io/task/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Client_api client_api = retrofit.create(Client_api.class);

        Call<List<Category_market>> call = client_api.getAllCategories();
        call.enqueue(new Callback<List<Category_market>>() {
            @Override
            public void onResponse(Call<List<Category_market>> call, Response<List<Category_market>> response) {
                categoryList = response.body();
                MarketAdapter adapter = new MarketAdapter(categoryList, getApplicationContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Category_market>> call, Throwable t) {

            }
        });
    }
}

