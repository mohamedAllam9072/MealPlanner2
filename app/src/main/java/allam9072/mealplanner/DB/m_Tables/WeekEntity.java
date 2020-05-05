package allam9072.mealplanner.DB.m_Tables;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class WeekEntity {
    @PrimaryKey(autoGenerate = true)
    private int weekId;
    private String week_name;
    private String week_date;

    public WeekEntity(String week_name, String week_date) {
        this.week_name = week_name;
        this.week_date = week_date;
    }


    public int getWeekId() {
        return weekId;
    }

    public String getWeek_name() {
        return week_name;
    }

    public String getWeek_date() {
        return week_date;
    }

    public void setWeekId(int weekId) {
        this.weekId = weekId;
    }
}
