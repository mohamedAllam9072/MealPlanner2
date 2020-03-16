package allam9072.mealplanner.DB.m_Tables;

import androidx.room.Entity;

@Entity(primaryKeys = {"wID","dID"})
public class WeekDaysXRefEntity {
    public int wID;
    public int dID;

    public WeekDaysXRefEntity(int wID, int dID) {
        this.wID = wID;
        this.dID = dID;
    }

    public int getwID() {
        return wID;
    }

    public int getdID() {
        return dID;
    }
}
