package allam9072.mealplanner.ui.list_grocery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GroceryListViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GroceryListViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is share fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}