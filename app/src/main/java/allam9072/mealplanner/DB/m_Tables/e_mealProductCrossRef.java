package allam9072.mealplanner.DB.m_Tables;

import androidx.room.Entity;

@Entity(primaryKeys = {"_id_meal","_id_product"})
public class e_mealProductCrossRef {
    public int _id_meal;
    public int _id_product;

    public e_mealProductCrossRef(int _id_meal, int _id_product) {
        this._id_meal = _id_meal;
        this._id_product = _id_product;
    }

    public int get_id_meal() {
        return _id_meal;
    }

    public int get_id_product() {
        return _id_product;
    }
}
