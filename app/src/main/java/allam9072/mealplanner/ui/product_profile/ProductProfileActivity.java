package allam9072.mealplanner.ui.product_profile;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import allam9072.mealplanner.R;

public class ProductProfileActivity extends AppCompatActivity {
    private TextView tv_title, tv_price, tv_weight, tv_description;
    private ImageView imageView;
    private ProductViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_profile);
        tv_title = findViewById(R.id.tv_product_name);
        tv_price = findViewById(R.id.tv_product_price);
        tv_weight = findViewById(R.id.tv_product_weight);
        tv_description = findViewById(R.id.tv_product_description);
        imageView = findViewById(R.id.iv_product);
        viewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        viewModel.getProduct_title().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tv_title.setText(s);
            }
        });
        viewModel.getProduct_price().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tv_price.setText(s);
            }
        });
        viewModel.getProduct_weight().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tv_weight.setText(s);
            }
        });
        viewModel.getProduct_description().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tv_description.setText(s);
            }
        });


    }
}

