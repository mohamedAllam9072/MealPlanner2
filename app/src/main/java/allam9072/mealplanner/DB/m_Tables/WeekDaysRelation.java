package allam9072.mealplanner.DB.m_Tables;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class WeekDaysRelation {
    @Embedded
    public WeekEntity week;
    @Relation(
            parentColumn = "weekId",
            entity = DayEntity.class,
            entityColumn = "dayId",
            associateBy = @Junction(
                    value = WeekDaysXRefEntity.class,
                    entityColumn = "dID",
                    parentColumn = "wID"
            )
    )
    public List<DayEntity> days;

}
