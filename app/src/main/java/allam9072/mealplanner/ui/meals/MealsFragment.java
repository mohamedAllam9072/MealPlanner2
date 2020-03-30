package allam9072.mealplanner.ui.meals;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import allam9072.mealplanner.DB.m_Tables.MealProductsRelation;
import allam9072.mealplanner.R;
import allam9072.mealplanner.ui.planMeal.MealPlanActivity;

public class MealsFragment extends Fragment {

    private MealsViewModel viewModel;
    private MealsAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.meals_fragment, container, false);
        viewModel = ViewModelProviders.of(getActivity()).get(MealsViewModel.class);
        adapter = new MealsAdapter(getContext());
        viewModel.getMealProducts().observe(getViewLifecycleOwner(), new Observer<List<MealProductsRelation>>() {
            @Override
            public void onChanged(List<MealProductsRelation> mealProductsRelations) {
                adapter.setMealProducts(mealProductsRelations);
            }
        });
        FloatingActionButton button = root.findViewById(R.id.btn_meals_frag);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MealPlanActivity.class);
                startActivity(intent);
            }
        });

        RecyclerView recyclerView = root.findViewById(R.id.rv_meals);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return root;
    }


}
