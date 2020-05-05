package allam9072.mealplanner.ui.recipe_profile;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import allam9072.mealplanner.DB.recipeInts;
import allam9072.mealplanner.R;

public class RecipesProfileActivity extends AppCompatActivity {
    private ImageView iv_main, iv_favorite, iv_link, iv_timer;
    private TextView tv_title, tv_instructions, tv_ingredients, tv_comments, tv_tags;
    private FloatingActionButton btn_add_to_cart;
    private RecyclerView rv;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_profile);
        intent = getIntent();
        init();
        setIv_main();
        setTexts();
        setRV();
        clicks();


    }


    private void init() {
        iv_favorite = findViewById(R.id.iv_rd_favorite_icon);
        iv_link = findViewById(R.id.iv_rd_link_icon);
        iv_main = findViewById(R.id.iv_rd_main_image);
        iv_timer = findViewById(R.id.iv_rd_timers_icon);
        tv_title = findViewById(R.id.tv_rd_title);
        tv_ingredients = findViewById(R.id.tv_ingredients_rd);
        tv_instructions = findViewById(R.id.tv_instructions_rd);
        tv_comments = findViewById(R.id.tv_comments_rd);
        tv_tags = findViewById(R.id.tv_tags_rd);
        btn_add_to_cart = findViewById(R.id.add_to_cart);
        rv = findViewById(R.id.rv_rd_integers);
    }

    private void setIv_main() {
        try {
            Picasso.with(getApplicationContext())
                    .load(intent.getStringExtra("rd_img"))
                    .placeholder(R.drawable.ic_app)
                    .error(R.drawable.ic_app)
                    .fit()
                    .centerCrop()
                    .into(iv_main);
        } catch (Exception ignored) {
        }
    }

    private void setTexts() {
        tv_title.setText(intent.getStringExtra("rd_name"));
        tv_ingredients.setText(intent.getStringExtra("rd_ingredients"));
        tv_instructions.setText(intent.getStringExtra("rd_instructions"));
        tv_comments.setText(intent.getStringExtra("rd_comments"));
        tv_tags.setText(intent.getStringExtra("rd_tags"));

    }

    private void setRV() {
        ArrayList<recipeInts> recipeInts = new ArrayList<>();
        recipeInts.add(new recipeInts("Calories", intent.getIntExtra("rd_calories", 0)));
        recipeInts.add(new recipeInts("Sugar", intent.getIntExtra("rd_sugar", 0)));
        recipeInts.add(new recipeInts("Carbs", intent.getIntExtra("rd_carbs", 0)));
        recipeInts.add(new recipeInts("Fiber", intent.getIntExtra("rd_fiber", 0)));
        recipeInts.add(new recipeInts("Protein", intent.getIntExtra("rd_protein", 0)));
        recipeInts.add(new recipeInts("Sat fat", intent.getIntExtra("rd_satfat", 0)));
        recipeInts.add(new recipeInts("Fat", intent.getIntExtra("rd_fat", 0)));
        recipeInts.add(new recipeInts("Servings", intent.getIntExtra("rd_servings", 0)));

        rv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        rv.setAdapter(new RecipeIntsAdapter(recipeInts));
    }

    private void timers() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dailog_timers, null);
        TextView tv_prep_time, tv_wait_time, tv_cook_time;
        tv_prep_time = view.findViewById(R.id.tv_prep_time_rd);
        tv_wait_time = view.findViewById(R.id.tv_wait_time_rd);
        tv_cook_time = view.findViewById(R.id.tv_cook_time_rd);
        tv_cook_time.setText(String.valueOf(intent.getIntExtra("rd_cook_time", 0)));
        tv_prep_time.setText(String.valueOf(intent.getIntExtra("rd_prep_time", 0)));
        tv_wait_time.setText(String.valueOf(intent.getIntExtra("rd_wait_time", 0)));
        builder.setView(view)
                .setTitle("Timers")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                })
                .create()
                .show();


    }

    private void clicks() {
        iv_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timers();
            }
        });
        iv_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RecipesProfileActivity.this, "link", Toast.LENGTH_SHORT).show();
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
//                startActivity(browserIntent);
            }
        });
    }


    private void getIntentData() {
        intent.getStringExtra("rd_id");
        intent.getStringExtra("rd_img");

        intent.getStringExtra("rd_name");
        intent.getStringExtra("rd_source");
        intent.getStringExtra("rd_comments");
        intent.getStringExtra("rd_instructions");
        intent.getStringExtra("rd_ingredients");
        intent.getStringExtra("rd_tags");

        intent.getIntExtra("rd_prep_time", 0);
        intent.getIntExtra("rd_cook_time", 0);
        intent.getIntExtra("rd_wait_time", 0);

        intent.getIntExtra("rd_servings", 0);
        intent.getIntExtra("rd_calories", 0);
        intent.getIntExtra("rd_fat", 0);
        intent.getIntExtra("rd_carbs", 0);
        intent.getIntExtra("rd_fiber", 0);
        intent.getIntExtra("rd_protein", 0);
        intent.getIntExtra("rd_satfat", 0);
        intent.getIntExtra("rd_sugar", 0);
    }


}
