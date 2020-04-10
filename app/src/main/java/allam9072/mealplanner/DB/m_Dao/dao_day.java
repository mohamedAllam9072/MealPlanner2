package allam9072.mealplanner.DB.m_Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import allam9072.mealplanner.DB.m_Tables.DayEntity;
import allam9072.mealplanner.DB.m_Tables.DayMealsRelation;
import allam9072.mealplanner.DB.m_Tables.DayMealsXRefEntity;

@Dao
public interface dao_day {
    @Insert
    void insert(DayEntity dayEntity);

    @Update
    void update(DayEntity dayEntity);

    @Delete
    void delete(DayEntity dayEntity);

    @Query("Select * From DayEntity")
    LiveData<List<DayEntity>> getAllDays();


    @Transaction
    @Query("select * From DayEntity where dayId =:dayID ")
    LiveData<List<DayMealsRelation>> getDayMeals(int dayID);

    @Insert
    void insertDayMeals(DayMealsXRefEntity dayMealsXRefEntity);


}
