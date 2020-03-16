package allam9072.mealplanner.DB.m_Tables;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class e_week {
    @PrimaryKey(autoGenerate = true)
    private int _id_week;
    private String week_name;

    public e_week(String week_name) {
        this.week_name = week_name;
    }

    public int get_id_week() {
        return _id_week;
    }

    public String getWeek_name() {
        return week_name;
    }

    public void set_id_week(int _id_week) {
        this._id_week = _id_week;
    }
}
