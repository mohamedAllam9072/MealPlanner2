package allam9072.mealplanner.ui.list_Recipes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import allam9072.mealplanner.DB.Recipes;
import allam9072.mealplanner.R;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.mVH> {
    private ArrayList<Recipes> recipes;
    private Context context;

    public RecipesAdapter(Context context, ArrayList<Recipes> recipes) {
        this.recipes = recipes;
        this.context = context;
    }

    @NonNull
    @Override
    public mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_recipes, parent, false);
        return new mVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mVH holder, int position) {
        holder.tv_name.setText(recipes.get(position).getName());
        holder.tv2.setText("" + recipes.get(position).getCalories());
        holder.tv3.setText("" + recipes.get(position).getCarbs());

    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class mVH extends RecyclerView.ViewHolder {
        TextView tv_name, tv2, tv3;
        ImageView imageView;

        public mVH(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_recipe_name);
            tv2 = itemView.findViewById(R.id.tv2_recipe);
            tv3 = itemView.findViewById(R.id.tv3_recipe);
            imageView = itemView.findViewById(R.id.iv_recipe);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, recipes.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
