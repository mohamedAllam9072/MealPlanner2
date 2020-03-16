package allam9072.mealplanner.DB.m_Tables;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class e_day {
    @PrimaryKey(autoGenerate = true)
    private int _id_day;
    private String day_name;
    @ColumnInfo(name = "FK_id_week")
    private int weekDay;

    public e_day(String day_name) {
        this.day_name = day_name;
    }

    public void set_id_day(int _id_day) {
        this._id_day = _id_day;
    }

    public int get_id_day() {
        return _id_day;
    }

    public String getDay_name() {
        return day_name;
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    public int getWeekDay() {
        return weekDay;
    }
}
