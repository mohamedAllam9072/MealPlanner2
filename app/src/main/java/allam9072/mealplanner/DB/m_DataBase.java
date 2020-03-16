package allam9072.mealplanner.DB;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import allam9072.mealplanner.DB.m_Dao.dao_day;
import allam9072.mealplanner.DB.m_Dao.dao_meal;
import allam9072.mealplanner.DB.m_Dao.dao_product;
import allam9072.mealplanner.DB.m_Dao.dao_week;
import allam9072.mealplanner.DB.m_Tables.DayEntity;
import allam9072.mealplanner.DB.m_Tables.DayMealsXRefEntity;
import allam9072.mealplanner.DB.m_Tables.MealEntity;
import allam9072.mealplanner.DB.m_Tables.MealProductXRefEntity;
import allam9072.mealplanner.DB.m_Tables.ProductEntity;
import allam9072.mealplanner.DB.m_Tables.WeekDaysXRefEntity;
import allam9072.mealplanner.DB.m_Tables.WeekEntity;

@Database(entities = {WeekEntity.class, DayEntity.class, MealEntity.class, ProductEntity.class,
        MealProductXRefEntity.class, DayMealsXRefEntity.class, WeekDaysXRefEntity.class}, version = 1, exportSchema = false)
public abstract class m_DataBase extends RoomDatabase {
    public abstract dao_week dao_week();

    public abstract dao_day dao_day();

    public abstract dao_meal dao_meal();

    public abstract dao_product dao_product();

    private static m_DataBase instance;

    public static m_DataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, m_DataBase.class, "MealPlannerDB")
                    .fallbackToDestructiveMigration()
                    .addCallback(callback)
                    .build();
        }
        return instance;

    }

    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new callbackAsyncTask(instance).execute();
        }
    };

    private static class callbackAsyncTask extends AsyncTask<Void, Void, Void> {
        private dao_week dao_week;
        private dao_day dao_day;
        private dao_meal dao_meal;
        private dao_product dao_product;

        public callbackAsyncTask(m_DataBase db) {
            dao_week = db.dao_week();
            dao_day = db.dao_day();
            dao_meal = db.dao_meal();
            dao_product = db.dao_product();
        }


        @Override
        protected Void doInBackground(Void... voids) {
            dao_week.insert(new WeekEntity("week 1"));
            dao_week.insert(new WeekEntity("week 2"));
            dao_week.insert(new WeekEntity("week 3"));


            dao_day.insert(new DayEntity("Saturday"));
            dao_day.insert(new DayEntity("Sunday"));
            dao_day.insert(new DayEntity("Monday"));
            dao_day.insert(new DayEntity("Tuesday"));
            dao_day.insert(new DayEntity("Wednesday"));
            dao_day.insert(new DayEntity("Thursday"));
            dao_day.insert(new DayEntity("Friday"));


            dao_meal.insert(new MealEntity("Breakfast", "list1"));
            dao_meal.insert(new MealEntity("Lunch", "list2"));
            dao_meal.insert(new MealEntity("Dinner", "list3"));

            dao_product.insert(new ProductEntity("product1", 10, 10));
            dao_product.insert(new ProductEntity("product2", 10, 10));
            dao_product.insert(new ProductEntity("product3", 10, 10));
            dao_product.insert(new ProductEntity("product4", 10, 10));
            dao_product.insert(new ProductEntity("product5", 10, 10));
            dao_product.insert(new ProductEntity("product6", 10, 10));
            dao_product.insert(new ProductEntity("product7", 10, 10));
            dao_product.insert(new ProductEntity("product8", 10, 10));
            dao_product.insert(new ProductEntity("product9", 10, 10));
            dao_product.insert(new ProductEntity("product0", 10, 10));

            dao_meal.insertMealProducts(new MealProductXRefEntity(1, 1));
            dao_meal.insertMealProducts(new MealProductXRefEntity(1, 2));
            dao_meal.insertMealProducts(new MealProductXRefEntity(1, 3));
            dao_meal.insertMealProducts(new MealProductXRefEntity(1, 4));
            dao_meal.insertMealProducts(new MealProductXRefEntity(2, 5));
            dao_meal.insertMealProducts(new MealProductXRefEntity(2, 6));
            dao_meal.insertMealProducts(new MealProductXRefEntity(2, 7));
            dao_meal.insertMealProducts(new MealProductXRefEntity(2, 8));
            dao_meal.insertMealProducts(new MealProductXRefEntity(3, 9));
            dao_meal.insertMealProducts(new MealProductXRefEntity(3, 10));
            dao_meal.insertMealProducts(new MealProductXRefEntity(3, 1));
            dao_meal.insertMealProducts(new MealProductXRefEntity(3, 2));

            dao_day.insertDayMeals(new DayMealsXRefEntity(1, 1));
            dao_day.insertDayMeals(new DayMealsXRefEntity(1, 2));
            dao_day.insertDayMeals(new DayMealsXRefEntity(1, 3));
            dao_day.insertDayMeals(new DayMealsXRefEntity(2, 1));
            dao_day.insertDayMeals(new DayMealsXRefEntity(2, 2));
            dao_day.insertDayMeals(new DayMealsXRefEntity(2, 3));
            dao_day.insertDayMeals(new DayMealsXRefEntity(3, 1));
            dao_day.insertDayMeals(new DayMealsXRefEntity(3, 2));
            dao_day.insertDayMeals(new DayMealsXRefEntity(3, 3));
            dao_day.insertDayMeals(new DayMealsXRefEntity(4, 1));
            dao_day.insertDayMeals(new DayMealsXRefEntity(4, 2));
            dao_day.insertDayMeals(new DayMealsXRefEntity(4, 3));
            dao_day.insertDayMeals(new DayMealsXRefEntity(5, 1));
            dao_day.insertDayMeals(new DayMealsXRefEntity(5, 2));
            dao_day.insertDayMeals(new DayMealsXRefEntity(5, 3));
            dao_day.insertDayMeals(new DayMealsXRefEntity(6, 1));
            dao_day.insertDayMeals(new DayMealsXRefEntity(6, 2));
            dao_day.insertDayMeals(new DayMealsXRefEntity(6, 3));
            dao_day.insertDayMeals(new DayMealsXRefEntity(7, 1));
            dao_day.insertDayMeals(new DayMealsXRefEntity(7, 2));
            dao_day.insertDayMeals(new DayMealsXRefEntity(7, 3));


            return null;
        }
    }
}
