package allam9072.mealplanner.ui.list_shopping;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import allam9072.mealplanner.DB.m_Tables.ProductEntity;
import allam9072.mealplanner.R;

public class ShoppingListFragment extends Fragment implements ShoppingAdapter.ProductCLickListener {

    private ShoppingViewModel viewModel;
    private ShoppingAdapter adapter = new ShoppingAdapter(this);
    private int ShoppingTotalCash = 0;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(this).get(ShoppingViewModel.class);
        View root = inflater.inflate(R.layout.fragment_shopping_list, container, false);
        viewModel.getProducts().observe(getViewLifecycleOwner(), new Observer<List<ProductEntity>>() {
            @Override
            public void onChanged(List<ProductEntity> products) {
                adapter.setProducts(products);
            }
        });
        recyclerView = root.findViewById(R.id.rv_shopping);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void click(int position) {
        ShoppingTotalCash += viewModel.getProducts().getValue().get(position).getProduct_price();
        Toast.makeText(getContext(), String.valueOf(ShoppingTotalCash), Toast.LENGTH_SHORT).show();

    }
}