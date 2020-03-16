package allam9072.mealplanner.ui.add_meal;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import allam9072.mealplanner.DB.m_Repository;
import allam9072.mealplanner.DB.m_Tables.e_meal;
import allam9072.mealplanner.DB.m_Tables.e_mealProductCrossRef;
import allam9072.mealplanner.DB.m_Tables.e_product;
import allam9072.mealplanner.DB.m_Tables.r_meal_products;

public class MealPlanViewModel extends AndroidViewModel {
    private LiveData<List<e_product>> AllProducts;

    private m_Repository repository;

    public MealPlanViewModel(Application application) {
        super(application);
        repository = new m_Repository(application);
        AllProducts = repository.getAllProducts();
    }

    void insert_meal(e_meal e_meal) {
        repository.insert_meal(e_meal);
    }

    void insert_product(e_product e_product) {
        repository.insert_product(e_product);
    }

    void insert_meal_product(e_mealProductCrossRef e_mealProductCrossRef) {
        repository.insert_meal_product(e_mealProductCrossRef);
    }

    void delete_meal(e_meal e_meal) {
        repository.delete_meal(e_meal);
    }

    void update_meal(e_meal e_meal) {
        repository.update_meal(e_meal);
    }

    public LiveData<List<e_product>> getAllProducts() {
        return AllProducts;
    }

}
