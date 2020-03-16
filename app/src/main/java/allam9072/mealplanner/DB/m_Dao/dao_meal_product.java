package allam9072.mealplanner.DB.m_Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import allam9072.mealplanner.DB.m_Tables.e_mealProductCrossRef;
import allam9072.mealplanner.DB.m_Tables.r_meal_products;

@Dao
public interface dao_meal_product {
    @Insert
    void insert_meal_product(e_mealProductCrossRef e_mealProductCrossRef);

    @Transaction
    @Query("SELECT * FROM e_mealProductCrossRef where _id_meal =1")
    LiveData<List<r_meal_products>> getMealWithProducts();
}
