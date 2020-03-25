package allam9072.mealplanner.ui.list_grocery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import allam9072.mealplanner.DB.m_Tables.ProductEntity;
import allam9072.mealplanner.R;
import allam9072.mealplanner.ui.view_product_profile.ProductProfileActivity;

public class GroceryListFragment extends Fragment {

    private GroceryViewModel viewModel;
    private GroceryAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        adapter = new GroceryAdapter(getContext());
        viewModel = ViewModelProviders.of(this).get(GroceryViewModel.class);
        viewModel.getProducts().observe(getViewLifecycleOwner(), new Observer<List<ProductEntity>>() {
            @Override
            public void onChanged(List<ProductEntity> products) {
                adapter.setProducts(products);
            }
        });
        View root = inflater.inflate(R.layout.fragment_grocery_list, container, false);
        FloatingActionButton button = root.findViewById(R.id.btn_add_product_grocery);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProductProfileActivity.class);
                startActivity(intent);
            }
        });
        RecyclerView recyclerView = root.findViewById(R.id.rv_grocery);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return root;
    }


}