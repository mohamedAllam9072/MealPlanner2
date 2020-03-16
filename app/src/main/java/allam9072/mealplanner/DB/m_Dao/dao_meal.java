package allam9072.mealplanner.DB.m_Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import allam9072.mealplanner.DB.m_Tables.e_meal;

@Dao
public interface dao_meal {
    @Insert
    void insert(e_meal e_meal);

    @Update
    void update(e_meal e_meal);

    @Delete
    void delete(e_meal e_meal);

    @Query("Select * from e_meal")
    LiveData<List<e_meal>> getAllMeals();

}
