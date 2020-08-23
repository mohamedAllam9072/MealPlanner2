package allam9072.mealplanner.ui.list_pantry;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import allam9072.mealplanner.R;

public class PantryListFragment extends Fragment {

    private PantryListViewModel pantryListViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        pantryListViewModel =
                ViewModelProviders.of(this).get(PantryListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pantry_list, container, false);
        return root;
    }
}