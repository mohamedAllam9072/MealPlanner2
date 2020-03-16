package allam9072.mealplanner.ui.list_weeks;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import allam9072.mealplanner.DB.Repo;
import allam9072.mealplanner.DB.m_Tables.WeekEntity;

public class WeeksViewModel extends AndroidViewModel {

    private LiveData<List<WeekEntity>> AllWeeks;
    private Repo repository;

    public WeeksViewModel(Application application) {
        super(application);
        repository = new Repo(application);
        AllWeeks = repository.getAllWeeks();


    }

    void insert_week(WeekEntity WeekEntity) {
        repository.insert_week(WeekEntity);
    }

    public LiveData<List<WeekEntity>> getAllWeeks() {
        return AllWeeks;
    }
}