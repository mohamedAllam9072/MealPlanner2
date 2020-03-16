package allam9072.mealplanner.DB.m_Tables;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class DayMealsRelation {
    @Embedded
    public DayEntity day;
    @Relation(
            parentColumn = "dayId",
            entity = MealEntity.class,
            entityColumn = "mealId",
            associateBy = @Junction(
                    value = DayMealsXRefEntity.class,
                    parentColumn = "d2ID",
                    entityColumn = "m2ID"))
    public List<MealEntity> meals;

}
