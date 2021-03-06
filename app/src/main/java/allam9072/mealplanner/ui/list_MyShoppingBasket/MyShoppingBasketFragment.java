package allam9072.mealplanner.ui.list_MyShoppingBasket;

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

public class MyShoppingBasketFragment extends Fragment {

    private MyShoppingBasketViewModel myShoppingBasketViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myShoppingBasketViewModel =
                ViewModelProviders.of(this).get(MyShoppingBasketViewModel.class);
        View root = inflater.inflate(R.layout.fragment_my_shopping_basket, container, false);
        final TextView textView = root.findViewById(R.id.text_send);
        myShoppingBasketViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}