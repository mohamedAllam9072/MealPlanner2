package allam9072.mealplanner.DB.m_Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import allam9072.mealplanner.DB.m_Tables.MealProductsRelation;
import allam9072.mealplanner.DB.m_Tables.ProductEntity;

@Dao
public interface dao_product {
    @Insert
    void insert(ProductEntity productEntity);

    @Update
    void update(ProductEntity productEntity);

    @Delete
    void delete(ProductEntity productEntity);

    @Query("select * from ProductEntity")
    LiveData<List<ProductEntity>> getAllProducts();

//    @Query("select * from MealProductXRefEntity where mId =1")
//    LiveData<List<MealProductsRelation>> getMealProducts(int mealID);


}
