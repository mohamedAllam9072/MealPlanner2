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
import allam9072.mealplanner.DB.m_Dao.dao_meal_product;
import allam9072.mealplanner.DB.m_Dao.dao_product;
import allam9072.mealplanner.DB.m_Dao.dao_week;
import allam9072.mealplanner.DB.m_Tables.e_day;
import allam9072.mealplanner.DB.m_Tables.e_meal;
import allam9072.mealplanner.DB.m_Tables.e_mealProductCrossRef;
import allam9072.mealplanner.DB.m_Tables.e_product;
import allam9072.mealplanner.DB.m_Tables.e_week;

@Database(entities = {e_week.class, e_day.class, e_meal.class, e_product.class, e_mealProductCrossRef.class}, version = 1, exportSchema = false)
public abstract class m_DataBase extends RoomDatabase {
    public abstract dao_week dao_week();

    public abstract dao_day dao_day();

    public abstract dao_meal dao_meal();

    public abstract dao_product dao_product();

    public abstract dao_meal_product dao_meal_product();

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
        private dao_meal_product dao_meal_product;

        public callbackAsyncTask(m_DataBase db) {
            dao_week = db.dao_week();
            dao_day = db.dao_day();
            dao_meal = db.dao_meal();
            dao_product = db.dao_product();
            dao_meal_product = db.dao_meal_product();
        }


        @Override
        protected Void doInBackground(Void... voids) {
            dao_week.insert(new e_week("week 1"));
            dao_week.insert(new e_week("week 2"));
            dao_week.insert(new e_week("week 3"));


            dao_day.insert(new e_day("Saturday"));
            dao_day.insert(new e_day("Sunday"));
            dao_day.insert(new e_day("Monday"));
            dao_day.insert(new e_day("Tuesday"));
            dao_day.insert(new e_day("Wednesday"));
            dao_day.insert(new e_day("Thursday"));
            dao_day.insert(new e_day("Friday"));


            dao_meal.insert(new e_meal("Breakfast", "list1"));
            dao_meal.insert(new e_meal("Lunch", "list2"));
            dao_meal.insert(new e_meal("Dinner", "list3"));

            dao_product.insert(new e_product("product1", 10, 10));
            dao_product.insert(new e_product("product2", 10, 10));
            dao_product.insert(new e_product("product3", 10, 10));
            dao_product.insert(new e_product("product4", 10, 10));
            dao_product.insert(new e_product("product5", 10, 10));
            dao_product.insert(new e_product("product6", 10, 10));
            dao_product.insert(new e_product("product7", 10, 10));
            dao_product.insert(new e_product("product8", 10, 10));
            dao_product.insert(new e_product("product9", 10, 10));
            dao_product.insert(new e_product("product0", 10, 10));

            dao_meal_product.insert_meal_product(new e_mealProductCrossRef(1, 1));
            dao_meal_product.insert_meal_product(new e_mealProductCrossRef(1, 2));
            dao_meal_product.insert_meal_product(new e_mealProductCrossRef(1, 3));
            dao_meal_product.insert_meal_product(new e_mealProductCrossRef(1, 4));
            dao_meal_product.insert_meal_product(new e_mealProductCrossRef(2, 5));
            dao_meal_product.insert_meal_product(new e_mealProductCrossRef(2, 6));
            dao_meal_product.insert_meal_product(new e_mealProductCrossRef(2, 7));
            dao_meal_product.insert_meal_product(new e_mealProductCrossRef(2, 8));
            dao_meal_product.insert_meal_product(new e_mealProductCrossRef(3, 9));
            dao_meal_product.insert_meal_product(new e_mealProductCrossRef(3, 10));
            dao_meal_product.insert_meal_product(new e_mealProductCrossRef(3, 1));
            dao_meal_product.insert_meal_product(new e_mealProductCrossRef(3, 2));


            return null;
        }
    }
}
