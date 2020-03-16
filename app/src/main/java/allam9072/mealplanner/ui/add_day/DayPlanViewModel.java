package allam9072.mealplanner.ui.add_day;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import allam9072.mealplanner.DB.m_Repository;
import allam9072.mealplanner.DB.m_Tables.e_meal;

public class DayPlanViewModel extends AndroidViewModel {
    private m_Repository repository;
    private LiveData<List<e_meal>> AllMeals;

    public DayPlanViewModel(@NonNull Application application) {
        super(application);
        this.repository = new m_Repository(application);
        AllMeals = repository.getAllMeals();
    }

    public LiveData<List<e_meal>> getAllMeals() {
        return AllMeals;
    }

    public void InsertMeal (e_meal e_meal){
        repository.insert_meal(e_meal);
    }
    public void UpdateMeal (e_meal e_meal){
        repository.update_meal(e_meal);
    }
}
