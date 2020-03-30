package allam9072.mealplanner.DB.m_Tables;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;


public class MealProductsRelation {
    @Embedded
    public MealEntity meal;
    @Relation(parentColumn = "mealId",
            entity = ProductEntity.class,
            entityColumn = "productId",
            associateBy = @Junction(
                    value = MealProductXRefEntity.class,
                    parentColumn = "mId",
                    entityColumn = "pId"))
    public List<ProductEntity> products;

}
