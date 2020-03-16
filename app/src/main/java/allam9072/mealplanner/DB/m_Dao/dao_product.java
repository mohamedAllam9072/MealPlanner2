package allam9072.mealplanner.DB.m_Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import allam9072.mealplanner.DB.m_Tables.e_product;

@Dao
public interface dao_product {
    @Insert
    void insert(e_product e_product);

    @Update
    void update(e_product e_product);

    @Delete
    void delete(e_product e_product);

    @Query("select * from e_product")
    LiveData<List<e_product>> getAllProducts();

    @Query("select * From e_product A INNER JOIN e_mealProductCrossRef B ON A._id_product = B._id_product Where _id_meal =1")
    LiveData<List<e_product>> getProductWithMeal();


}
