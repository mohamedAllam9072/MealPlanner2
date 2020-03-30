package allam9072.mealplanner.ui.meals;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import allam9072.mealplanner.DB.m_Tables.MealProductsRelation;
import allam9072.mealplanner.R;
import allam9072.mealplanner.ui.planMeal.MealPlanActivity;

public class MealsAdapter extends RecyclerView.Adapter<MealsAdapter.mVH> {
    private Context context;
    private List<MealProductsRelation> mealProducts = new ArrayList<>();

    public MealsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MealsAdapter.mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_meal_products_2, parent, false);
        return new mVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealsAdapter.mVH holder, int position) {
        holder.tv_mealTitle.setText(mealProducts.get(position).meal.getMeal_name());
        String s = "";
        for (int i = 0; i < mealProducts.get(position).products.size(); i++) {
            s += mealProducts.get(position).products.get(i).getProduct_name() + " ";
        }
        holder.tv_mealProducts.setText(s);
    }

    @Override
    public int getItemCount() {
        return mealProducts.size();
    }

    public void setMealProducts(List<MealProductsRelation> mealProducts) {
        this.mealProducts = mealProducts;
    }

    public class mVH extends RecyclerView.ViewHolder {
        TextView tv_mealTitle, tv_mealProducts;

        public mVH(@NonNull View itemView) {
            super(itemView);
            tv_mealTitle = itemView.findViewById(R.id.tv_mealTitle2);
            tv_mealProducts = itemView.findViewById(R.id.tv_mealProducts2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MealPlanActivity.class);
                    intent.putExtra("mealId", mealProducts.get(getAdapterPosition()).meal.getMealId());
                    Toast.makeText(context, String.valueOf(mealProducts.get(getAdapterPosition()).meal.getMealId()), Toast.LENGTH_SHORT).show();
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });


        }
    }
}
