package allam9072.mealplanner.DB.m_Tables;

import androidx.room.Entity;

@Entity(primaryKeys = {"d2ID", "m2ID"})
public class DayMealsXRefEntity {
    public int d2ID;
    public int m2ID;

    public DayMealsXRefEntity(int d2ID, int m2ID) {
        this.d2ID = d2ID;
        this.m2ID = m2ID;
    }

    public int getD2ID() {
        return d2ID;
    }

    public int getM2ID() {
        return m2ID;
    }
}
