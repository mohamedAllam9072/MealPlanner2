package allam9072.mealplanner.ui.list_pantry;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PantryListViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PantryListViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is tools fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}