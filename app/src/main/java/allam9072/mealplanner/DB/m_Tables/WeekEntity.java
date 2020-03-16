package allam9072.mealplanner.DB.m_Tables;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class WeekEntity {
    @PrimaryKey(autoGenerate = true)
    private int weekId;
    private String week_name;

    public WeekEntity(String week_name) {
        this.week_name = week_name;
    }

    public int getWeekId() {
        return weekId;
    }

    public String getWeek_name() {
        return week_name;
    }

    public void setWeekId(int weekId) {
        this.weekId = weekId;
    }
}
