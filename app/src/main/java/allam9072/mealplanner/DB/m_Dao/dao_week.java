package allam9072.mealplanner.DB.m_Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import allam9072.mealplanner.DB.m_Tables.e_week;

@Dao
public interface dao_week {
    @Insert
    void insert(e_week e_week);

    @Update
    void update(e_week e_week);

    @Delete
    void delete(e_week e_week);

    @Query("Select * From e_week")
    LiveData<List<e_week>> getAllWeeks();
}
