package allam9072.mealplanner.ui.planWeek;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
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
    private WeekViewModel viewModel;
    private LifecycleOwner lifecycleOwner;
    private String[] days_title = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private List<DayEntity> weekDays = new ArrayList<>();
    private List<MealEntity> dayMeals = new ArrayList<>();
    private List<MealProductsRelation> mealProducts = new ArrayList<>();
    private listener listener;
    private NestedAdapter nestedAdapter;

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
    public void onBindViewHolder(@NonNull mVH holder, final int position) {
        holder.tv_DayTitle.setText(weekDays.get(position).getDay_name());
        holder.tv_DayDate.setText("" + weekDays.get(position).getDayId());
        holder.nested_rv.setLayoutManager(new LinearLayoutManager(context));
        viewModel.getDayMeals(weekDays.get(position).getDayId())
                .observe(lifecycleOwner, new Observer<List<DayMealsRelation>>() {
                    @Override
                    public void onChanged(List<DayMealsRelation> dayMeals) {
                        setDayMeals(dayMeals.get(0).meals);
                    }
                });
        holder.nested_rv.setAdapter(nestedAdapter);

    }

    @Override
    public int getItemCount() {
        return weekDays.size();
    }

    public void setWeekDays(List<DayEntity> weekDays) {
        this.weekDays = weekDays;
        notifyDataSetChanged();
    }

    public interface listener {
        void click(DayEntity day);
    }

    public void setListener(WeekAdapter.listener listener) {
        this.listener = listener;
    }

    public void setDayMeals(List<MealEntity> dayMeals) {
        this.dayMeals = dayMeals;
    }

    public void setMealProducts(List<MealProductsRelation> mealProducts) {
        this.mealProducts = mealProducts;
    }

    public void setViewModel(WeekViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner;
    }

    public class mVH extends RecyclerView.ViewHolder {
        TextView tv_DayTitle, tv_DayDate;
        RecyclerView nested_rv;
        ImageButton btn_add_new_meal;

        public mVH(@NonNull final View itemView) {
            super(itemView);
            tv_DayDate = itemView.findViewById(R.id.tv_dayDate_f);
            tv_DayTitle = itemView.findViewById(R.id.tv_dayTitle_f);
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
}
