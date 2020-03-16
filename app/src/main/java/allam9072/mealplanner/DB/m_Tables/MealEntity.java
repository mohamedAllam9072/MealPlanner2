package allam9072.mealplanner.DB.m_Tables;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MealEntity {
    @PrimaryKey(autoGenerate = true)
    private int mealId;
    private String meal_name;
    private String selectedProductsList;


    public MealEntity(String meal_name, String selectedProductsList) {
        this.meal_name = meal_name;
        this.selectedProductsList = selectedProductsList;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public int getMealId() {
        return mealId;
    }

    public String getMeal_name() {
        return meal_name;
    }

    public String getSelectedProductsList() {
        return selectedProductsList;
    }
}
