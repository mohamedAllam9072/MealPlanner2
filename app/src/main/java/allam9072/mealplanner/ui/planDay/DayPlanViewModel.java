package allam9072.mealplanner.ui.planDay;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import allam9072.mealplanner.DB.Repo;
import allam9072.mealplanner.DB.m_Tables.MealEntity;

public class DayPlanViewModel extends AndroidViewModel {
    private Repo repository;
    private LiveData<List<MealEntity>> AllMeals;

    public DayPlanViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repo(application);
        AllMeals = repository.getAllMeals();
    }

    public LiveData<List<MealEntity>> getAllMeals() {
        return AllMeals;
    }

    public void InsertMeal (MealEntity MealEntity){
        repository.insert_meal(MealEntity);
    }
    public void UpdateMeal (MealEntity MealEntity){
        repository.update_meal(MealEntity);
    }
}
