package allam9072.mealplanner.ui.list_shopping;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import allam9072.mealplanner.DB.Repo;
import allam9072.mealplanner.DB.m_Tables.ProductEntity;

public class ShoppingViewModel extends AndroidViewModel {
    private Repo repo;
    private LiveData<List<ProductEntity>> products;

    public ShoppingViewModel(Application application) {
        super(application);
        repo = new Repo(application);
        products = repo.getAllProducts();
    }

    public LiveData<List<ProductEntity>> getProducts() {
        return products;
    }
}