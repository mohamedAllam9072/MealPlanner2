package allam9072.mealplanner.DB.m_Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import allam9072.mealplanner.DB.m_Tables.WeekDaysRelation;
import allam9072.mealplanner.DB.m_Tables.WeekDaysXRefEntity;
import allam9072.mealplanner.DB.m_Tables.WeekEntity;

@Dao
public interface dao_week {
    @Insert
    void insert(WeekEntity e_week);

    @Update
    void update(WeekEntity e_week);

    @Delete
    void delete(WeekEntity e_week);

    @Query("Select * From WeekEntity")
    LiveData<List<WeekEntity>> getAllWeeks();

    @Transaction
    @Query("SELECT * FROM WeekEntity where weekId =:weekID")
    LiveData<List<WeekDaysRelation>> getWeekDays(int weekID);

    @Insert
    void insertWeekDays(WeekDaysXRefEntity weekDaysXRefEntity);
}
