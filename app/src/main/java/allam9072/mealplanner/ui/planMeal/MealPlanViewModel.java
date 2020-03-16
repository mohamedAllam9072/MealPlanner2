package allam9072.mealplanner.ui.planMeal;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import allam9072.mealplanner.DB.Repo;

import allam9072.mealplanner.DB.m_Tables.MealEntity;
import allam9072.mealplanner.DB.m_Tables.MealProductXRefEntity;
import allam9072.mealplanner.DB.m_Tables.ProductEntity;

public class MealPlanViewModel extends AndroidViewModel {
    private LiveData<List<ProductEntity>> AllProducts;
    private Repo repository;

    public MealPlanViewModel(Application application) {
        super(application);
        repository = new Repo(application);
        AllProducts = repository.getAllProducts();
    }

    public void insert_meal(MealEntity meal) {
        repository.insert_meal(meal);
    }
    void insert_product(ProductEntity product) {
        repository.insert_product(product);
    }
    void insert_meal_product(MealProductXRefEntity mealProductXRef) {
        repository.insert_meal_product(mealProductXRef);
    }

    void delete_meal(MealEntity meal) {
        repository.delete_meal(meal);
    }

    void update_meal(MealEntity meal) {
        repository.update_meal(meal);
    }

    public LiveData<List<ProductEntity>> getAllProducts() {
        return AllProducts;
    }



}
