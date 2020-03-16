package allam9072.mealplanner.ui.add_week;

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

import allam9072.mealplanner.DB.m_Tables.e_meal;
import allam9072.mealplanner.DB.m_Tables.e_product;
import allam9072.mealplanner.DB.m_Tables.r_meal_products;
import allam9072.mealplanner.R;
import allam9072.mealplanner.ui.add_meal.MealPlanActivity;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class NestedAdapter extends RecyclerView.Adapter<NestedAdapter.mVH> {
    private Context context;
    private List<e_meal> meals;
    private List<e_product>productsWithMeal;

//
//    public NestedAdapter(Context context, List<e_meal> meals) {
//        this.context = context;
//        this.meals = meals;
//    }-


    public NestedAdapter(Context context, List<e_meal> meals, List<e_product>productsWithMeal) {
        this.context = context;
        this.meals = meals;
        this.productsWithMeal = productsWithMeal;
    }

    @NonNull
    @Override
    public NestedAdapter.mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_meal_and_products, parent, false);
        return new mVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NestedAdapter.mVH holder, int position) {
        holder.tv_mealTitle.setText(meals.get(position).getMeal_name());
        String s = " ";
        for (int i = 0; i <productsWithMeal.size() ; i++) {
             s += productsWithMeal.get(i).getProduct_name() ;

        }
        holder.tv_mealProducts.setText(s);

    }

    @Override
    public int getItemCount() {
        return meals.size();
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
                    intent.putExtra("item1_week_name", "week name");
                    intent.putExtra("item2_day_name", "day name");
                    intent.putExtra("item3_meal_name", "meal name");
                    intent.putExtra("item4_meal_id", meals.get(getAdapterPosition()).get_id_meal());
                    intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                    Toast.makeText(context, "4items intent", Toast.LENGTH_SHORT).show();
                }
            });


        }
    }


}
