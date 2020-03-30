package allam9072.mealplanner.ui.planMeal;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import allam9072.mealplanner.DB.Repo;
import allam9072.mealplanner.DB.m_Tables.MealEntity;
import allam9072.mealplanner.DB.m_Tables.MealProductXRefEntity;
import allam9072.mealplanner.DB.m_Tables.MealProductsRelation;
import allam9072.mealplanner.DB.m_Tables.ProductEntity;

public class MealPlanViewModel extends AndroidViewModel {
    private Repo repo;
    private LiveData<List<ProductEntity>> AllProducts;
    private LiveData<List<MealProductsRelation>> mealProducts;
    private LiveData<List<MealProductsRelation>> new_mealProducts;


    public MealPlanViewModel(Application application) {
        super(application);
        repo = new Repo(application);
        AllProducts = repo.getAllProducts();
    }

    public LiveData<List<MealProductsRelation>> getNew_mealProducts(int mealId) {
        repo = new Repo(getApplication());
        new_mealProducts = repo.getNewMealProducts(mealId);
        return new_mealProducts;
    }

    public LiveData<List<ProductEntity>> getAllProducts() {
        return AllProducts;
    }

    public LiveData<List<MealProductsRelation>> getMealProducts() {
        return mealProducts;
    }


    public void InsertMeal(MealEntity meal) {
        repo.insert_meal(meal);
    }

    public void InsertProduct(ProductEntity product) {
        repo.insert_product(product);
    }

    public void InsertMealProduct(MealProductXRefEntity mealProductXRef) {
        repo.insert_meal_product(mealProductXRef);
    }

    void DeleteMeal(MealEntity meal) {
        repo.delete_meal(meal);
    }

    void UpdateMeal(MealEntity meal) {
        repo.update_meal(meal);
    }


}
