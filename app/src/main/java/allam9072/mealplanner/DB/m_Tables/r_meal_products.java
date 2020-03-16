package allam9072.mealplanner.DB.m_Tables;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class r_meal_products {
    @Embedded
    public e_meal e_meal;
    @Relation(parentColumn = "_id_meal",
            entityColumn = "_id_product",
            entity = e_product.class,
            associateBy = @Junction(e_mealProductCrossRef.class))
    public List<e_product> products;
}
