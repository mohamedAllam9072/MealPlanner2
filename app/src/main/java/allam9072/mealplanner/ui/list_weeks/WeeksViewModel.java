package allam9072.mealplanner.ui.list_weeks;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import allam9072.mealplanner.DB.m_Repository;
import allam9072.mealplanner.DB.m_Tables.e_week;

public class WeeksViewModel extends AndroidViewModel {

    private LiveData<List<e_week>> AllWeeks;
    private m_Repository repository;

    public WeeksViewModel(Application application) {
        super(application);
        repository = new m_Repository(application);
        AllWeeks = repository.getAllWeeks();


    }

    void insert_week(e_week e_week) {
        repository.insert_week(e_week);
    }

    public LiveData<List<e_week>> getAllWeeks() {
        return AllWeeks;
    }
}