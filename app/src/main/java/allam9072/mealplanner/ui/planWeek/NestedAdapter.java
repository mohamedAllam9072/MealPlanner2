package allam9072.mealplanner.ui.planWeek;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import allam9072.mealplanner.DB.m_Tables.MealProductsRelation;
import allam9072.mealplanner.R;
import allam9072.mealplanner.ui.planMeal.MealPlanActivity;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class NestedAdapter extends RecyclerView.Adapter<NestedAdapter.mVH> {
    private Context context;
    private List<MealProductsRelation> meal_products;

    public NestedAdapter(Context context, List<MealProductsRelation> meal_products) {
        this.context = context;
        this.meal_products = meal_products;
    }

    @NonNull
    @Override
    public NestedAdapter.mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_meal_products, parent, false);
        return new mVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NestedAdapter.mVH holder, int position) {
        holder.tv_mealTitle.setText(meal_products.get(position).meal.getMeal_name());
        String s = " ";
        for (int i = 0; i < meal_products.get(position).products.size(); i++) {
            s += meal_products.get(position).products.get(i).getProduct_name() + " ";
        }
        holder.tv_mealProducts.setText(s);
    }

    @Override
    public int getItemCount() {
        return meal_products.size();
    }

    public class mVH extends RecyclerView.ViewHolder {
        TextView tv_mealTitle, tv_mealProducts;

        public mVH(@NonNull View itemView) {
            super(itemView);
            tv_mealTitle = itemView.findViewById(R.id.tv_mealTitle);
            tv_mealProducts = itemView.findViewById(R.id.tv_mealProducts);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MealPlanActivity.class);
                    intent.putExtra("mealId", meal_products.get(getAdapterPosition()).meal.getMealId());
                    intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                    Toast.makeText(context, " NestedAdapter", Toast.LENGTH_SHORT).show();
                }
            });


        }
    }


}
