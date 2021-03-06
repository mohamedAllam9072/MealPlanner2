package allam9072.mealplanner.ui.recipe_profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

<<<<<<< HEAD
=======
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
>>>>>>> 5b85b402d9001178bead429d35c7e4c6fb830356
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.clans.fab.FloatingActionButton;
<<<<<<< HEAD
=======
import com.google.android.material.textfield.TextInputEditText;
>>>>>>> 5b85b402d9001178bead429d35c7e4c6fb830356
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import allam9072.mealplanner.DB.recipeInts;
import allam9072.mealplanner.R;
import allam9072.mealplanner.ui.planWeek.DatePickerFragment;
import allam9072.mealplanner.ui.planWeek.WeekActivity;

public class RecipesProfileActivity extends AppCompatActivity {
    private ImageView iv_main;
    private TextView tv_title, tv_instructions, tv_ingredients, tv_comments, tv_prep_time, tv_wait_time, tv_cook_time;
    private RecyclerView rv_integers, rv_tags;
    private Intent intent;
    private FloatingActionButton fab_source, fab_favorite, fab_timers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_profile);

        intent = getIntent();
        init();
        image_view();
        setTexts();
        recycler_view();
        timers();
<<<<<<< HEAD
        floatingActionMenu();
=======
//        floatingActionMenu();

>>>>>>> 5b85b402d9001178bead429d35c7e4c6fb830356

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recipe, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.menu_item_weekTitle:
//                AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                View view = getLayoutInflater().inflate(R.layout.dialog_meal_title, null);
//                final TextInputEditText editText = view.findViewById(R.id.editText_mealTitle);
//                builder.setView(view)
//                        .setTitle("Week Title")
//                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                setTitle(editText.getText().toString());
//                            }
//                        })
//                        .setNegativeButton("no", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Toast.makeText(WeekActivity.this, "no", Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .create()
//                        .show();
//
//                break;
//            case R.id.menu_item_weekDate:
//                DatePickerFragment datePicker = new DatePickerFragment();
//                datePicker.show(getSupportFragmentManager(), "date picker");
//                break;
//        }
        return super.onOptionsItemSelected(item);
    }


    private void init() {

        Toolbar toolbar = findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(" ");

        iv_main = findViewById(R.id.iv_rd_main_image);
        tv_title = findViewById(R.id.tv_rd_title);
        tv_ingredients = findViewById(R.id.tv_ingredients_rd);
        tv_instructions = findViewById(R.id.tv_instructions_rd);
        tv_comments = findViewById(R.id.tv_comments_rd);
        rv_integers = findViewById(R.id.rv_rd_integers);
        rv_tags = findViewById(R.id.rv_tags_rd);
<<<<<<< HEAD
        fab_source = findViewById(R.id.fab_source);
        fab_favorite = findViewById(R.id.fab_favorite);
        fab_timers = findViewById(R.id.fab_timers);
=======
//        fab_source = findViewById(R.id.fab_source);
//        fab_favorite = findViewById(R.id.fab_favorite);
//        fab_timers = findViewById(R.id.fab_timers);
>>>>>>> 5b85b402d9001178bead429d35c7e4c6fb830356

        tv_prep_time = findViewById(R.id.tv_prep_time_rd);
        tv_wait_time = findViewById(R.id.tv_wait_time_rd);
        tv_cook_time = findViewById(R.id.tv_cook_time_rd);

    }

    private void image_view() {
        try {
            Picasso.with(getApplicationContext())
                    .load(intent.getStringExtra("rd_img"))
                    .placeholder(R.drawable.ic_app)
                    .error(R.color.set1_1)
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
    }

    private void recycler_view() {
        ArrayList<recipeInts> recipeInts = new ArrayList<>();
        recipeInts.add(new recipeInts("Calories", intent.getIntExtra("rd_calories", 0)));
        recipeInts.add(new recipeInts("Sugar", intent.getIntExtra("rd_sugar", 0)));
        recipeInts.add(new recipeInts("Carbs", intent.getIntExtra("rd_carbs", 0)));
        recipeInts.add(new recipeInts("Fiber", intent.getIntExtra("rd_fiber", 0)));
        recipeInts.add(new recipeInts("Protein", intent.getIntExtra("rd_protein", 0)));
        recipeInts.add(new recipeInts("Sat fat", intent.getIntExtra("rd_satfat", 0)));
        recipeInts.add(new recipeInts("Fat", intent.getIntExtra("rd_fat", 0)));
        recipeInts.add(new recipeInts("Servings", intent.getIntExtra("rd_servings", 0)));
        rv_integers.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        rv_integers.setAdapter(new RecipeIntsAdapter(recipeInts));

        ArrayList<String> tags = new ArrayList<>();
        if (intent.getStringExtra("rd_tag1") != null) {
            tags.add(intent.getStringExtra("rd_tag1"));
        }
        if (intent.getStringExtra("rd_tag2") != null) {
            tags.add(intent.getStringExtra("rd_tag2"));
        }
        if (intent.getStringExtra("rd_tag3") != null) {
            tags.add(intent.getStringExtra("rd_tag3"));
        }
        if (intent.getStringExtra("rd_tag4") != null) {
            tags.add(intent.getStringExtra("rd_tag4"));
        }
        if (intent.getStringExtra("rd_tag5") != null) {
            tags.add(intent.getStringExtra("rd_tag5"));
        }

        rv_tags.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        rv_tags.setAdapter(new TagsAdapter(getApplicationContext(), tags));
    }

<<<<<<< HEAD
    private void floatingActionMenu() {
        fab_timers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RecipesProfileActivity.this, "s", Toast.LENGTH_SHORT).show();
            }
        });
        fab_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RecipesProfileActivity.this, "favorite", Toast.LENGTH_SHORT).show();
            }
        });
        fab_source.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RecipesProfileActivity.this, "source", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void timers() {
        tv_cook_time.setText(String.valueOf(intent.getIntExtra("rd_cook_time", 0)));
        tv_prep_time.setText(String.valueOf(intent.getIntExtra("rd_prep_time", 0)));
        tv_wait_time.setText(String.valueOf(intent.getIntExtra("rd_wait_time", 0)));
    }
=======
//    private void floatingActionMenu() {
//        fab_timers.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(RecipesProfileActivity.this, "s", Toast.LENGTH_SHORT).show();
//            }
//        });
//        fab_favorite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(RecipesProfileActivity.this, "favorite", Toast.LENGTH_SHORT).show();
//            }
//        });
//        fab_source.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(RecipesProfileActivity.this, "source", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    private void timers() {
        tv_cook_time.setText(String.valueOf(intent.getIntExtra("rd_cook_time", 0)));
        tv_prep_time.setText(String.valueOf(intent.getIntExtra("rd_prep_time", 0)));
        tv_wait_time.setText(String.valueOf(intent.getIntExtra("rd_wait_time", 0)));
    }

>>>>>>> 5b85b402d9001178bead429d35c7e4c6fb830356



}
