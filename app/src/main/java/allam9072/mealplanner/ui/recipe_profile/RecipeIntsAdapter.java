package allam9072.mealplanner.ui.recipe_profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import allam9072.mealplanner.DB.recipeInts;
import allam9072.mealplanner.R;

public class RecipeIntsAdapter extends RecyclerView.Adapter<RecipeIntsAdapter.mVH> {
    ArrayList<recipeInts> recipeInts;

    public RecipeIntsAdapter(ArrayList<recipeInts> recipeInts) {
        this.recipeInts = recipeInts;
    }

    @NonNull
    @Override
    public mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_recipe_integers, parent, false);
        return new mVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mVH holder, int position) {
        holder.textView1.setText(recipeInts.get(position).getName());
        holder.textView2.setText(""+recipeInts.get(position).getValue());

    }

    @Override
    public int getItemCount() {
        return recipeInts.size();
    }

    public class mVH extends RecyclerView.ViewHolder {
        TextView textView1, textView2;

        public mVH(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.tv_1_recipe_ints);
            textView2 = itemView.findViewById(R.id.tv_2_recipe_ints);
        }
    }
}
