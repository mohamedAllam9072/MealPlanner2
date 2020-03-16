package allam9072.mealplanner.ui.add_week;

import android.app.Application;
import android.app.ListActivity;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import allam9072.mealplanner.DB.m_Repository;
import allam9072.mealplanner.DB.m_Tables.e_day;
import allam9072.mealplanner.DB.m_Tables.e_meal;
import allam9072.mealplanner.DB.m_Tables.e_product;
import allam9072.mealplanner.DB.m_Tables.r_meal_products;

public class WeekViewModel extends AndroidViewModel {
    private m_Repository repository;
    private LiveData<List<e_day>> days;
    private LiveData<List<e_meal>> meals;
    private LiveData<List<e_product>> productsWithMeal;

    public WeekViewModel(@NonNull Application application) {
        super(application);
        this.repository = new m_Repository(application);
        days = repository.getAllDays();
        meals = repository.getAllMeals();
        productsWithMeal =repository.getProductsWithMeal();
    }

    public LiveData<List<e_day>> getDays() {
        return days;
    }

    public LiveData<List<e_meal>> getMeals() {
        return meals;
    }

    public LiveData<List<e_product>> getProductsWithMeal() {
        return productsWithMeal;
    }
}
