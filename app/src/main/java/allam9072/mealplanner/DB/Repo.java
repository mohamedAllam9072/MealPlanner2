package allam9072.mealplanner.DB;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import allam9072.mealplanner.DB.m_Dao.dao_day;
import allam9072.mealplanner.DB.m_Dao.dao_meal;
import allam9072.mealplanner.DB.m_Dao.dao_product;
import allam9072.mealplanner.DB.m_Dao.dao_week;
import allam9072.mealplanner.DB.m_Tables.DayEntity;
import allam9072.mealplanner.DB.m_Tables.DayMealsRelation;
import allam9072.mealplanner.DB.m_Tables.DayMealsXRefEntity;
import allam9072.mealplanner.DB.m_Tables.MealEntity;
import allam9072.mealplanner.DB.m_Tables.MealProductXRefEntity;
import allam9072.mealplanner.DB.m_Tables.MealProductsRelation;
import allam9072.mealplanner.DB.m_Tables.ProductEntity;
import allam9072.mealplanner.DB.m_Tables.WeekDaysRelation;
import allam9072.mealplanner.DB.m_Tables.WeekEntity;

public class Repo {
    private dao_week dao_week;
    private dao_day dao_day;
    private dao_meal dao_meal;
    private dao_product dao_product;

    private LiveData<List<WeekEntity>> allWeeks;
    private LiveData<List<DayEntity>> allDays;
    private LiveData<List<MealEntity>> allMeals;
    private LiveData<List<ProductEntity>> allProducts;
    private LiveData<List<MealProductsRelation>> mealProducts;

    private LiveData<List<WeekDaysRelation>> weekDays;
    private LiveData<List<DayMealsRelation>> dayMeals;
    private LiveData<List<MealProductsRelation>> new_mealProducts;


    public Repo(Application application) {
        m_DataBase m_dataBase = m_DataBase.getInstance(application);
        dao_week = m_dataBase.dao_week();
        dao_day = m_dataBase.dao_day();
        dao_meal = m_dataBase.dao_meal();
        dao_product = m_dataBase.dao_product();

        allWeeks = dao_week.getAllWeeks();
        allDays = dao_day.getAllDays();
        allMeals = dao_meal.getAllMeals();
        allProducts = dao_product.getAllProducts();
        mealProducts = dao_meal.getMealProducts();


    }


    /*** insert methods****************************************************************************************************/
    public void insert_week(WeekEntity weekEntity) {
        new InsertWeekAsyncTask(dao_week).execute(weekEntity);
    }

    public void insert_day(DayEntity dayEntity) {
        dao_day.insert(dayEntity);
    }

    public void insert_meal(MealEntity mealEntity) {
        new InsertMealAsyncTask(dao_meal).execute(mealEntity);
    }

    public void insert_product(ProductEntity productEntity) {
        new InsertProductAsyncTask(dao_product).execute(productEntity);
    }

    public void insert_meal_product(MealProductXRefEntity mealProductXRefEntity) {
        new InsertMealProductAsyncTask(dao_meal).execute(mealProductXRefEntity);
    }

    /*** delete methods****************************************************************************************************/
    public void delete_meal(MealEntity mealEntity) {
        new DeleteMealAsyncTask(dao_meal).execute(mealEntity);
    }

    public void delete_meal_product(MealProductXRefEntity mealProductXRefEntity) {
        new DeleteMealProductsXRefAsyncTask(dao_meal).execute(mealProductXRefEntity);
    }

    /*** update methods****************************************************************************************************/
    public void update_meal(MealEntity mealEntity) {
        new UpdateMealAsyncTask(dao_meal).execute(mealEntity);
    }

    /*** get methods****************************************************************************************************/
    public LiveData<List<WeekEntity>> getAllWeeks() {
        return allWeeks;
    }

    public LiveData<List<DayEntity>> getAllDays() {
        return allDays;
    }

    public LiveData<List<MealEntity>> getAllMeals() {
        return allMeals;
    }

    public LiveData<List<ProductEntity>> getAllProducts() {
        return allProducts;
    }

    public LiveData<List<DayMealsRelation>> getDayMeals() {
        return dayMeals;
    }

    public LiveData<List<MealProductsRelation>> getMealProducts() {
        return mealProducts;
    }

    public LiveData<List<WeekDaysRelation>> getWeekDays(int weekID) {
        weekDays = dao_week.getWeekDays(weekID);
        return weekDays;
    }

    public LiveData<List<DayMealsRelation>> getDayMeals(int dayID) {
        dayMeals = dao_day.getDayMeals(dayID);
        return dayMeals;
    }

    public LiveData<List<MealProductsRelation>> getNewMealProducts(int mealId) {
        new_mealProducts = dao_meal.getMealByID(mealId);
        return new_mealProducts;
    }
    /*** ASYNC TASK methods****************************************************************************************************/
    /***** INSERT*/
    private static class InsertWeekAsyncTask extends AsyncTask<WeekEntity, Void, Void> {
        private dao_week dao_week;

        private InsertWeekAsyncTask(dao_week dao_week) {
            this.dao_week = dao_week;
        }

        @Override
        protected Void doInBackground(WeekEntity... Weeks) {
            dao_week.insert(Weeks[0]);
            return null;
        }
    }

    private static class InsertMealAsyncTask extends AsyncTask<MealEntity, Void, Void> {
        private dao_meal dao_meal;

        public InsertMealAsyncTask(dao_meal dao_meal) {
            this.dao_meal = dao_meal;
        }

        @Override
        protected Void doInBackground(MealEntity... Meals) {
            dao_meal.insert(Meals[0]);
            return null;
        }
    }

    private static class InsertProductAsyncTask extends AsyncTask<ProductEntity, Void, Void> {
        private dao_product dao_product;

        public InsertProductAsyncTask(dao_product dao_product) {
            this.dao_product = dao_product;
        }

        @Override
        protected Void doInBackground(ProductEntity... products) {
            dao_product.insert(products[0]);
            return null;
        }
    }

    private static class InsertMealProductAsyncTask extends AsyncTask<MealProductXRefEntity, Void, Void> {
        private dao_meal dao_meal;

        public InsertMealProductAsyncTask(dao_meal dao_meal) {
            this.dao_meal = dao_meal;
        }

        @Override
        protected Void doInBackground(MealProductXRefEntity... mealProductCrossRefs) {
            dao_meal.insertMealProducts(mealProductCrossRefs[0]);
            return null;
        }
    }

    private static class InsertDayMealsAsyncTask extends AsyncTask<DayMealsXRefEntity, Void, Void> {
        private dao_day dao_day;

        public InsertDayMealsAsyncTask(allam9072.mealplanner.DB.m_Dao.dao_day dao_day) {
            this.dao_day = dao_day;
        }

        @Override
        protected Void doInBackground(DayMealsXRefEntity... DayMealsXRefs) {
            dao_day.insertDayMeals(DayMealsXRefs[0]);
            return null;
        }
    }

    /****  DELETE*/
    private static class DeleteMealAsyncTask extends AsyncTask<MealEntity, Void, Void> {
        private dao_meal dao_meal;

        public DeleteMealAsyncTask(dao_meal dao_meal) {
            this.dao_meal = dao_meal;
        }

        @Override
        protected Void doInBackground(MealEntity... Meals) {
            dao_meal.delete(Meals[0]);
            return null;
        }
    }

    private static class DeleteMealProductsXRefAsyncTask extends AsyncTask<MealProductXRefEntity, Void, Void> {
        private dao_meal dao_meal;

        public DeleteMealProductsXRefAsyncTask(dao_meal dao_meal) {
            this.dao_meal = dao_meal;
        }

        @Override
        protected Void doInBackground(MealProductXRefEntity... mealProducts) {
            this.dao_meal.deleteMealProduct(mealProducts[0]);
            return null;
        }
    }


    /****  UPDATE*/
    private static class UpdateMealAsyncTask extends AsyncTask<MealEntity, Void, Void> {
        private dao_meal dao_meal;

        public UpdateMealAsyncTask(dao_meal dao_meal) {
            this.dao_meal = dao_meal;
        }

        @Override
        protected Void doInBackground(MealEntity... Meals) {
            dao_meal.update(Meals[0]);
            return null;
        }
    }

}
