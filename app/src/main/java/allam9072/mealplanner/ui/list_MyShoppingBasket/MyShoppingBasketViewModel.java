package allam9072.mealplanner.ui.list_MyShoppingBasket;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyShoppingBasketViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyShoppingBasketViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is send fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}