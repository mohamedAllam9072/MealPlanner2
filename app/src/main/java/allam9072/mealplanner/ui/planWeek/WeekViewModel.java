package allam9072.mealplanner.ui.planWeek;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import allam9072.mealplanner.DB.Repo;
import allam9072.mealplanner.DB.m_Tables.DayEntity;
import allam9072.mealplanner.DB.m_Tables.DayMealsRelation;
import allam9072.mealplanner.DB.m_Tables.MealEntity;
import allam9072.mealplanner.DB.m_Tables.MealProductsRelation;

public class WeekViewModel extends AndroidViewModel {
    private Repo repository;
    private LiveData<List<DayEntity>> days;
    private LiveData<List<MealEntity>> meals;
    private LiveData<List<MealProductsRelation>> meal_products ;
    private LiveData<List<DayMealsRelation>>day_meals;

    public WeekViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repo(application);
        days = repository.getAllDays();
        meals = repository.getAllMeals();
        meal_products = repository.getMealProducts();
        day_meals =repository.getDayMeals();
    }


    public LiveData<List<DayEntity>> getDays() {
        return days;
    }

    public LiveData<List<MealEntity>> getMeals() {
        return meals;
    }

    public LiveData<List<MealProductsRelation>> getMeal_products() {
        return meal_products;
    }

    public LiveData<List<DayMealsRelation>> getDay_meals() {
        return day_meals;
    }
}
