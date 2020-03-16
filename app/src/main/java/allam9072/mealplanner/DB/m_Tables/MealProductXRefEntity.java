package allam9072.mealplanner.DB.m_Tables;

import androidx.room.Entity;

@Entity(primaryKeys = {"mId","pId"})
public class MealProductXRefEntity {
    public int mId;
    public int pId;

    public MealProductXRefEntity(int mId, int pId) {
        this.mId = mId;
        this.pId = pId;
    }

    public int getmId() {
        return mId;
    }

    public int getpId() {
        return pId;
    }
}
