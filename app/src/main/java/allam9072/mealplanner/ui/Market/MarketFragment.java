package allam9072.mealplanner.ui.Market;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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

public class MarketFragment extends Fragment {

    private MarketViewModel mViewModel;
    private RecyclerView recyclerView;
    private List<Category_market> categoryList = new ArrayList<>();


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.market_fragment, container, false);
        recyclerView = view.findViewById(R.id.rv_market);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        retrofit();
        return view;
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
                MarketAdapter adapter = new MarketAdapter(categoryList, getContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Category_market>> call, Throwable t) {

            }
        });
    }


}