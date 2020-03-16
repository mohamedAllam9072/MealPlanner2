package allam9072.mealplanner.ui.planWeek;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import allam9072.mealplanner.DB.m_Tables.DayEntity;
import allam9072.mealplanner.DB.m_Tables.DayMealsRelation;
import allam9072.mealplanner.DB.m_Tables.MealEntity;
import allam9072.mealplanner.DB.m_Tables.MealProductsRelation;
import allam9072.mealplanner.R;
import allam9072.mealplanner.ui.planMeal.MealPlanActivity;

public class WeekAdapter extends RecyclerView.Adapter<WeekAdapter.mVH> {
    private Context context;
    private List<DayEntity> days = new ArrayList<>();
    private List<MealEntity> meals = new ArrayList<>();
    private List<MealProductsRelation> meal_products = new ArrayList<>();
    private List<DayMealsRelation> day_meals = new ArrayList<>();
    private listener listener;

    public WeekAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_day_full, parent, false);
        return new mVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mVH holder, int position) {
        holder.tv_DayTitle.setText(days.get(position).getDay_name());
        holder.tv_DayDate.setText(days.get(position).getDay_name());
        holder.nested_rv.setLayoutManager(new LinearLayoutManager(context));
        holder.nested_rv.setAdapter(
                new NestedAdapter(context, meal_products));

    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public class mVH extends RecyclerView.ViewHolder {
        TextView tv_DayTitle, tv_DayDate;
        RecyclerView nested_rv;
        ImageButton btn_add_new_meal;

        public mVH(@NonNull final View itemView) {
            super(itemView);
            tv_DayDate = itemView.findViewById(R.id.tv_dayTitle_f);
            tv_DayTitle = itemView.findViewById(R.id.tv_dayDate_f);
            btn_add_new_meal = itemView.findViewById(R.id.btn_add_new_meal_f);
            btn_add_new_meal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MealPlanActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
            nested_rv = itemView.findViewById(R.id.rv_nested_f);


        }
    }

    public interface listener {
        void click(DayEntity day);
    }

    public void setListener(WeekAdapter.listener listener) {
        this.listener = listener;
    }

    /**
     * this method refer to observes in Main_activity view_model calling
     */
    public void setDays(List<DayEntity> days) {
        this.days = days;
        notifyDataSetChanged();
    }

    public void setMeals(List<MealEntity> meals) {
        this.meals = meals;
        notifyDataSetChanged();
    }

    public void setMeal_products(List<MealProductsRelation> meal_products) {
        this.meal_products = meal_products;
    }

    public void setDay_meals(List<DayMealsRelation> day_meals) {
        this.day_meals = day_meals;
    }
}
