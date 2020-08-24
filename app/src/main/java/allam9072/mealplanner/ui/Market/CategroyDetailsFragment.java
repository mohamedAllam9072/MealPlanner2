package allam9072.mealplanner.ui.Market;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import allam9072.mealplanner.DB.market.Category_market;
import allam9072.mealplanner.DB.market.Client_api;
import allam9072.mealplanner.DB.market.Product_market;
import allam9072.mealplanner.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CategroyDetailsFragment extends Fragment {

    private MarketViewModel mViewModel;
    private RecyclerView rv;
    private String cat_name, cat_image;
    private int cat_id;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.categroy_details_fragment, container, false);
        rv = view.findViewById(R.id.rv_2);
        rv.setLayoutManager(new GridLayoutManager(getContext(), 2));

        cat_id = getArguments().getInt("cat_id");
        cat_name = getArguments().getString("cat_name");
        cat_image = getArguments().getString("cat_image");

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
                List<Category_market> categories = response.body();

                List<Product_market> productList = categories.get(cat_id - 1).getProducts();
                rv.setAdapter(new ProductsAdapter(getContext(), productList));
            }

            @Override
            public void onFailure(Call<List<Category_market>> call, Throwable t) {
                Toast.makeText(getContext(), "fail", Toast.LENGTH_SHORT).show();
            }
        });

    }
}