package allam9072.mealplanner.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import allam9072.mealplanner.DB.Recipes;
import allam9072.mealplanner.R;
import allam9072.mealplanner.ui.recipe_profile.RecipesProfileActivity;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.mVH> implements Filterable {
    private ArrayList<Recipes> recipes;
    private ArrayList<Recipes> list2;
    private Context context;
    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Recipes> filtered_list = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filtered_list.addAll(list2);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Recipes recipes : list2) {
                    if (recipes.getName().toLowerCase().contains(filterPattern)) {
                        filtered_list.add(recipes);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filtered_list;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            recipes.clear();
            recipes.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public RecipesAdapter(Context context, ArrayList<Recipes> recipes) {
        this.recipes = recipes;
        this.list2 = new ArrayList<>(recipes);
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull mVH holder, int position) {
        holder.tv_name.setText(recipes.get(position).getName());
        holder.tv2.setText("" + recipes.get(position).getCalories());
        holder.tv3.setText("" + recipes.get(position).getCarbs());
        try {
            Picasso.with(context)
                    .load(recipes.get(position).getImage1())
                    //  .placeholder(R.mipmap.ic_launcher)
                    .error(R.drawable.ic_recipes)
                    .fit()
                    .centerCrop()
                    .into(holder.imageView);
        } catch (Exception ignored) {
        }

    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    @NonNull
    @Override
    public mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_frag_home, parent, false);
        return new mVH(view);
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    public class mVH extends RecyclerView.ViewHolder {
        TextView tv_name, tv2, tv3;
        ImageView imageView;

        public mVH(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_1_i_f_home);
            tv2 = itemView.findViewById(R.id.tv_2_i_f_home);
            tv3 = itemView.findViewById(R.id.tv_3_i_f_home);
            imageView = itemView.findViewById(R.id.iv_i_f_home);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, RecipesProfileActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("rd_id", recipes.get(getAdapterPosition()).getId());
                    intent.putExtra("rd_img", recipes.get(getAdapterPosition()).getImage1());
                    intent.putExtra("rd_name", recipes.get(getAdapterPosition()).getName());
                    intent.putExtra("rd_source", recipes.get(getAdapterPosition()).getSource());
                    intent.putExtra("rd_comments", recipes.get(getAdapterPosition()).getComments());
                    intent.putExtra("rd_instructions", recipes.get(getAdapterPosition()).getInstructions());
                    intent.putExtra("rd_ingredients", recipes.get(getAdapterPosition()).getIngredients());
                    intent.putExtra("rd_tag1", recipes.get(getAdapterPosition()).getTag1());
                    intent.putExtra("rd_tag2", recipes.get(getAdapterPosition()).getTag2());
                    intent.putExtra("rd_tag3", recipes.get(getAdapterPosition()).getTag3());
                    intent.putExtra("rd_tag4", recipes.get(getAdapterPosition()).getTag4());
                    intent.putExtra("rd_tag5", recipes.get(getAdapterPosition()).getTag5());

                    intent.putExtra("rd_prep_time", recipes.get(getAdapterPosition()).getPreptime());
                    intent.putExtra("rd_cook_time", recipes.get(getAdapterPosition()).getCooktime());
                    intent.putExtra("rd_wait_time", recipes.get(getAdapterPosition()).getWaittime());
                    intent.putExtra("rd_servings", recipes.get(getAdapterPosition()).getServings());
                    intent.putExtra("rd_calories", recipes.get(getAdapterPosition()).getCalories());
                    intent.putExtra("rd_fat", recipes.get(getAdapterPosition()).getFat());
                    intent.putExtra("rd_carbs", recipes.get(getAdapterPosition()).getCarbs());
                    intent.putExtra("rd_fiber", recipes.get(getAdapterPosition()).getFiber());
                    intent.putExtra("rd_protein", recipes.get(getAdapterPosition()).getProtein());
                    intent.putExtra("rd_satfat", recipes.get(getAdapterPosition()).getSatfat());
                    intent.putExtra("rd_sugar", recipes.get(getAdapterPosition()).getSugar());
                    context.startActivity(intent);
                }
            });
        }
    }
}
