package allam9072.mealplanner.DB.m_Tables;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class e_meal {
    @PrimaryKey(autoGenerate = true)
    private int _id_meal;
    private String meal_name;
    private String selectedProductsList;
    @ColumnInfo(name = "FK_id_day")
    private int dayMeal;

    public e_meal(String meal_name, String selectedProductsList) {
        this.meal_name = meal_name;
        this.selectedProductsList = selectedProductsList;
    }

    public void set_id_meal(int _id_meal) {
        this._id_meal = _id_meal;
    }

    public int get_id_meal() {
        return _id_meal;
    }

    public String getMeal_name() {
        return meal_name;
    }

    public int getDayMeal() {
        return dayMeal;
    }

    public void setDayMeal(int dayMeal) {
        this.dayMeal = dayMeal;
    }

    public String getSelectedProductsList() {
        return selectedProductsList;
    }
}
