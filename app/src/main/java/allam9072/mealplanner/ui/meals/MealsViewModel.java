package allam9072.mealplanner.ui.meals;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import allam9072.mealplanner.DB.Repo;
import allam9072.mealplanner.DB.m_Tables.MealProductsRelation;

public class MealsViewModel extends AndroidViewModel {
    private Repo repo;
    private LiveData<List<MealProductsRelation>> mealProducts;

    public MealsViewModel(@NonNull Application application) {
        super(application);
        repo = new Repo(application);
        //  mealProducts = repo.getMealProducts();
    }

    public LiveData<List<MealProductsRelation>> getMealProducts() {
        return mealProducts;
    }
}
