package allam9072.mealplanner.ui.favorite;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import allam9072.mealplanner.DB.Recipes;
import allam9072.mealplanner.R;
import allam9072.mealplanner.ui.recipe_profile.RecipesProfileActivity;
import de.hdodenhof.circleimageview.CircleImageView;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.mVH> {
    private Context context;
    private ArrayList<Recipes> favorite_recipes;

    public FavoriteAdapter(Context context, ArrayList<Recipes> favorite_recipes) {
        this.context = context;
        this.favorite_recipes = favorite_recipes;
    }

    @NonNull
    @Override
    public mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new mVH(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_linear_recipes, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull mVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return favorite_recipes.size();
    }

    public class mVH extends RecyclerView.ViewHolder {
        TextView textView1, textView2, textView3;
        CircleImageView circleImageView;

        public mVH(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.tv1_linear_recipe_item);
            textView2 = itemView.findViewById(R.id.tv2_linear_recipe_item);
            textView3 = itemView.findViewById(R.id.tv3_linear_recipe_item);
            circleImageView = itemView.findViewById(R.id.iv_linear_recipe_item);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, RecipesProfileActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("rd_id", favorite_recipes.get(getAdapterPosition()).getId());
                    intent.putExtra("rd_img", favorite_recipes.get(getAdapterPosition()).getImage1());
                    intent.putExtra("rd_name", favorite_recipes.get(getAdapterPosition()).getName());
                    intent.putExtra("rd_source", favorite_recipes.get(getAdapterPosition()).getSource());
                    intent.putExtra("rd_comments", favorite_recipes.get(getAdapterPosition()).getComments());
                    intent.putExtra("rd_instructions", favorite_recipes.get(getAdapterPosition()).getInstructions());
                    intent.putExtra("rd_ingredients", favorite_recipes.get(getAdapterPosition()).getIngredients());
                    intent.putExtra("rd_tag1", favorite_recipes.get(getAdapterPosition()).getTag1());
                    intent.putExtra("rd_tag2", favorite_recipes.get(getAdapterPosition()).getTag2());
                    intent.putExtra("rd_tag3", favorite_recipes.get(getAdapterPosition()).getTag3());
                    intent.putExtra("rd_tag4", favorite_recipes.get(getAdapterPosition()).getTag4());
                    intent.putExtra("rd_tag5", favorite_recipes.get(getAdapterPosition()).getTag5());

                    intent.putExtra("rd_prep_time", favorite_recipes.get(getAdapterPosition()).getPreptime());
                    intent.putExtra("rd_cook_time", favorite_recipes.get(getAdapterPosition()).getCooktime());
                    intent.putExtra("rd_wait_time", favorite_recipes.get(getAdapterPosition()).getWaittime());
                    intent.putExtra("rd_servings", favorite_recipes.get(getAdapterPosition()).getServings());
                    intent.putExtra("rd_calories", favorite_recipes.get(getAdapterPosition()).getCalories());
                    intent.putExtra("rd_fat", favorite_recipes.get(getAdapterPosition()).getFat());
                    intent.putExtra("rd_carbs", favorite_recipes.get(getAdapterPosition()).getCarbs());
                    intent.putExtra("rd_fiber", favorite_recipes.get(getAdapterPosition()).getFiber());
                    intent.putExtra("rd_protein", favorite_recipes.get(getAdapterPosition()).getProtein());
                    intent.putExtra("rd_satfat", favorite_recipes.get(getAdapterPosition()).getSatfat());
                    intent.putExtra("rd_sugar", favorite_recipes.get(getAdapterPosition()).getSugar());
                    context.startActivity(intent);
                }
            });
        }


    }

}
