package allam9072.mealplanner.ui.product_profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProductViewModel extends ViewModel {
    private MutableLiveData<String> product_title;
    private MutableLiveData<String> product_price;
    private MutableLiveData<String> product_weight;
    private MutableLiveData<String> product_description;

    public ProductViewModel() {
        product_title = new MutableLiveData<>();
        product_price = new MutableLiveData<>();
        product_weight = new MutableLiveData<>();
        product_description = new MutableLiveData<>();
        product_title.setValue("product title");
        product_weight.setValue("11 KG");
        product_price.setValue("1000 $");
        product_description.setValue("Prefix for the text describing how often a plant should be watered. Used in combination with watering_needs_suffix.\n" +
                "Content description for the header hero image that is show at the top of the plant detail screen.");
    }

    public LiveData<String> getProduct_title() {
        return product_title;
    }

    public LiveData<String> getProduct_price() {
        return product_price;
    }

    public LiveData<String> getProduct_weight() {
        return product_weight;
    }

    public LiveData<String> getProduct_description() {
        return product_description;
    }
}
