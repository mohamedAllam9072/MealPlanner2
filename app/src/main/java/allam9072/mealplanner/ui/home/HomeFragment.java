package allam9072.mealplanner.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.List;

import allam9072.mealplanner.DB.Category;
import allam9072.mealplanner.DB.JsonAPI;
import allam9072.mealplanner.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private SliderView sliderView;
    private RecyclerView recyclerView;
    adapter adapter;
    List<Category> categoryList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        sliderView = root.findViewById(R.id.imageSlider);

        recyclerView = root.findViewById(R.id.rv);
        setRecyclerView();
        recyclerView.setFocusable(false);

        setSlider();
        retrofit();

        return root;
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
                categoryList = response.body();
                adapter = new adapter(getContext(), categoryList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

            }
        });

    }

    private void setRecyclerView() {
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (adapter.getItemViewType(position)) {
                    case 1:
                        return 1;
                    default:
                        return 2;
                }
            }
        });
        recyclerView.setLayoutManager(layoutManager);

    }

    private void setSlider() {

        SliderAdapterExample sliderAdapterExample = new SliderAdapterExample(getContext());
        sliderView.setSliderAdapter(sliderAdapterExample);
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM);
        //set indicator animation by using SliderLayout.IndicatorAnimations.
        // :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();
    }
}