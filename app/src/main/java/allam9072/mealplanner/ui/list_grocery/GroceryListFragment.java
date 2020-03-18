package allam9072.mealplanner.ui.list_grocery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import allam9072.mealplanner.R;

public class GroceryListFragment extends Fragment {

    private GroceryListViewModel groceryListViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //using data binding
        groceryListViewModel =
                ViewModelProviders.of(this).get(GroceryListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_grocery_list, container, false);
        final TextView textView = root.findViewById(R.id.text_share);
        groceryListViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}