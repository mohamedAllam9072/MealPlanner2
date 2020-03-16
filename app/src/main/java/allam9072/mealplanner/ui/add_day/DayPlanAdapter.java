package allam9072.mealplanner.ui.add_day;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import allam9072.mealplanner.DB.m_Tables.e_meal;
import allam9072.mealplanner.R;

public class DayPlanAdapter extends RecyclerView.Adapter<DayPlanAdapter.mVH> {
    private List<e_meal> meals = new ArrayList<>();

    private listener listener;


    @NonNull
    @Override
    public mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_meal_full_view, parent, false);
        return new mVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mVH holder, int position) {
        holder.tv_MealTitle.setText(meals.get(position).getMeal_name());
        holder.tv_SelectedProducts.setText(meals.get(position).getSelectedProductsList());
//        holder.tv_MealTitle.setText(productsWithMeals.get(position).e_meal.getMeal_name());
//        holder.tv_SelectedProducts.setText(productsWithMeals.get(position).e_meal.getSelectedProductsList());
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public class mVH extends RecyclerView.ViewHolder {
        TextView tv_MealTitle, tv_SelectedProducts;

        public mVH(@NonNull View itemView) {
            super(itemView);
            tv_MealTitle = itemView.findViewById(R.id.tv_meal_title);
            tv_SelectedProducts = itemView.findViewById(R.id.tv_selected_products);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.click(meals.get(position));
                    }
                }
            });

        }

    }

    public interface listener {
        void click(e_meal e_meal);
    }

    public void setListener(DayPlanAdapter.listener listener) {
        this.listener = listener;
    }

    /**
     * this method refer to observes in Main_activity view_model calling
     */
    public void setMeals(List<e_meal> e_meals) {
        this.meals = e_meals;
        notifyDataSetChanged();
    }



    public e_meal getMealAt(int position) {
        return meals.get(position);
    }


}
