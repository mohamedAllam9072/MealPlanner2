package allam9072.mealplanner.DB.m_Tables;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DayEntity {
    @PrimaryKey(autoGenerate = true)
    private int dayId;
    private String day_name;

    public DayEntity(String day_name) {
        this.day_name = day_name;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public int getDayId() {
        return dayId;
    }

    public String getDay_name() {
        return day_name;
    }

}
