package allam9072.mealplanner.ui.list_grocery;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import allam9072.mealplanner.DB.Repo;
import allam9072.mealplanner.DB.m_Tables.ProductEntity;

public class GroceryViewModel extends AndroidViewModel {

    private LiveData<List<ProductEntity>> products;
    private Repo repo;

    public GroceryViewModel(Application application) {
        super(application);
        repo = new Repo(application);
        products = repo.getAllProducts();

    }

    public LiveData<List<ProductEntity>> getProducts() {
        return products;
    }

    public void insert_product(ProductEntity product) {
        repo.insert_product(product);
    }

}