package allam9072.mealplanner.DB.m_Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import allam9072.mealplanner.DB.m_Tables.e_day;

@Dao
public interface dao_day {
    @Insert
    void insert(e_day e_day);

    @Update
    void update(e_day e_day);

    @Delete
    void delete(e_day e_day);

    @Query("Select * From e_day")
    LiveData<List<e_day>> getAllDays();



}
