package allam9072.mealplanner.DB.m_Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import allam9072.mealplanner.DB.m_Tables.MealEntity;
import allam9072.mealplanner.DB.m_Tables.MealProductXRefEntity;
import allam9072.mealplanner.DB.m_Tables.MealProductsRelation;


@Dao
public interface dao_meal {
    @Insert
    void insert(MealEntity mealEntity);

    @Update
    void update(MealEntity mealEntity);

    @Delete
    void delete(MealEntity mealEntity);

    @Query("Select * from MealEntity")
    LiveData<List<MealEntity>> getAllMeals();

    @Query("Select * from MealEntity where mealId =:mId")
    LiveData<List<MealEntity>> getMealByID(int mId);

    @Transaction
    @Query("SELECT * FROM MealEntity")
    LiveData<List<MealProductsRelation>> getNewMealProducts();

    @Insert
    void insertMealProducts(MealProductXRefEntity mealProductXRefEntity);

}
