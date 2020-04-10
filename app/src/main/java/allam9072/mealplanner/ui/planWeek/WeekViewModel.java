package allam9072.mealplanner.ui.planWeek;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import allam9072.mealplanner.DB.Repo;
import allam9072.mealplanner.DB.m_Tables.DayMealsRelation;
import allam9072.mealplanner.DB.m_Tables.MealProductsRelation;
import allam9072.mealplanner.DB.m_Tables.WeekDaysRelation;

public class WeekViewModel extends AndroidViewModel {
    private Repo repo;
    private LiveData<List<WeekDaysRelation>> weekDays;
    private LiveData<List<DayMealsRelation>> dayMeals;
    private LiveData<List<MealProductsRelation>> mealProducts;


    public WeekViewModel(@NonNull Application application) {
        super(application);
        this.repo = new Repo(application);
        mealProducts = repo.getMealProducts();
        dayMeals = repo.getDayMeals();
    }

    public LiveData<List<WeekDaysRelation>> getWeekDays(int weekID) {
        repo = new Repo(getApplication());
        weekDays = repo.getWeekDays(weekID);
        return weekDays;
    }

    public LiveData<List<DayMealsRelation>> getDayMeals(int dayID) {
        repo = new Repo(getApplication());
        dayMeals = repo.getDayMeals(dayID);
        return dayMeals;
    }

    public LiveData<List<MealProductsRelation>> getMealProducts(int mealID) {
        repo = new Repo(getApplication());
        mealProducts = repo.getNewMealProducts(mealID);
        return mealProducts;
    }
}
