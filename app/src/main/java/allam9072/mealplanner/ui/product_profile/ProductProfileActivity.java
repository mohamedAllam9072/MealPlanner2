package allam9072.mealplanner.ui.product_profile;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import allam9072.mealplanner.R;

public class ProductProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_profile);
        //xml short cut ===> pp


    }

    private void init() {

        TextView tv_name = findViewById(R.id.tv_product_name);

    }
//    private void setIv_main() {
//        try {
//            Picasso.with(getApplicationContext())
//                    .load(intent.getStringExtra("rd_img"))
//                    .placeholder(R.drawable.ic_app)
//                    .error(R.drawable.ic_app)
//                    .fit()
//                    .centerCrop()
//                    .into(iv_main);
//        } catch (Exception ignored) {
//        }
//    }
}

