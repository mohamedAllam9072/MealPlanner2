package allam9072.mealplanner.DB;

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
import allam9072.mealplanner.DB.m_Tables.r_meal_products;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class m_Repository {
    private dao_week dao_week;
    private dao_day dao_day;
    private dao_meal dao_meal;
    private dao_product dao_product;
    private dao_meal_product dao_meal_product;

    private LiveData<List<e_week>> allWeeks;
    private LiveData<List<e_day>> allDays;
    private LiveData<List<e_meal>> allMeals;
    private LiveData<List<e_product>> allProducts;
    private LiveData<List<e_product>> productsWithMeal;

    public m_Repository(Application application) {
        m_DataBase m_dataBase = m_DataBase.getInstance(application);
        dao_week = m_dataBase.dao_week();
        allWeeks = dao_week.getAllWeeks();
        dao_day = m_dataBase.dao_day();
        dao_meal = m_dataBase.dao_meal();
        dao_meal_product = m_dataBase.dao_meal_product();
        dao_product = m_dataBase.dao_product();
        allDays = dao_day.getAllDays();
        allMeals = dao_meal.getAllMeals();
        allProducts = dao_product.getAllProducts();
        productsWithMeal = dao_product.getProductWithMeal();

    }

    /*** insert methods****************************************************************************************************/
    public void insert_week(e_week e_week) {
        new InsertWeekAsyncTask(dao_week).execute(e_week);
    }
    public void insert_day(e_day e_day) {
        dao_day.insert(e_day);
    }
    public void insert_meal(e_meal e_meal) {
        new InsertMealAsyncTask(dao_meal).execute(e_meal);
    }
    public void insert_product(e_product e_product) {
        new InsertProductAsyncTask(dao_product).execute(e_product);
    }
    public void insert_meal_product(e_mealProductCrossRef e_mealProductCrossRef) {
        new InsertMealProductAsyncTask(dao_meal_product).execute(e_mealProductCrossRef);
    }
    /*** delete methods****************************************************************************************************/
    public void delete_meal(e_meal e_meal) {
        new DeleteMealAsyncTask(dao_meal).execute(e_meal);
    }
    /*** update methods****************************************************************************************************/
    public void update_meal(e_meal e_meal) {
        new UpdateMealAsyncTask(dao_meal).execute(e_meal);
    }
    /*** get methods****************************************************************************************************/
    public LiveData<List<e_week>> getAllWeeks() {
        return allWeeks;
    }
    public LiveData<List<e_day>> getAllDays() {
        return allDays;
    }
    public LiveData<List<e_meal>> getAllMeals() {
        return allMeals;
    }
    public LiveData<List<e_product>> getAllProducts() {
        return allProducts;
    }
    public LiveData<List<e_product>> getProductsWithMeal() {
        return productsWithMeal;
    }

    /*** ASYNC TASK methods****************************************************************************************************/
    /***** INSERT*/
    private static class InsertWeekAsyncTask extends AsyncTask<e_week, Void, Void> {
        private dao_week dao_week;

        private InsertWeekAsyncTask(dao_week dao_week) {
            this.dao_week = dao_week;
        }

        @Override
        protected Void doInBackground(e_week... e_weeks) {
            dao_week.insert(e_weeks[0]);
            return null;
        }
    }
    private static class InsertMealAsyncTask extends AsyncTask<e_meal, Void, Void> {
        private dao_meal dao_meal;

        public InsertMealAsyncTask(dao_meal dao_meal) {
            this.dao_meal = dao_meal;
        }

        @Override
        protected Void doInBackground(e_meal... e_meals) {
            dao_meal.insert(e_meals[0]);
            return null;
        }
    }
    private static class InsertProductAsyncTask extends AsyncTask<e_product, Void, Void> {
        private dao_product dao_product;

        public InsertProductAsyncTask(dao_product dao_product) {
            this.dao_product = dao_product;
        }

        @Override
        protected Void doInBackground(e_product... products) {
            dao_product.insert(products[0]);
            return null;
        }
    }
    private static class InsertMealProductAsyncTask extends AsyncTask<e_mealProductCrossRef, Void, Void> {
        private dao_meal_product dao_meal_product;

        public InsertMealProductAsyncTask(dao_meal_product dao_meal_product) {
            this.dao_meal_product = dao_meal_product;
        }

        @Override
        protected Void doInBackground(e_mealProductCrossRef... mealProductCrossRefs) {
            dao_meal_product.insert_meal_product(mealProductCrossRefs[0]);
            return null;
        }
    }
    /****  DELETE*/
    private static class DeleteMealAsyncTask extends AsyncTask<e_meal, Void, Void> {
        private dao_meal dao_meal;

        public DeleteMealAsyncTask(dao_meal dao_meal) {
            this.dao_meal = dao_meal;
        }

        @Override
        protected Void doInBackground(e_meal... e_meals) {
            dao_meal.delete(e_meals[0]);
            return null;
        }
    }
    /****  UPDATE*/
    private static class UpdateMealAsyncTask extends AsyncTask<e_meal, Void, Void> {
        private dao_meal dao_meal;

        public UpdateMealAsyncTask(dao_meal dao_meal) {
            this.dao_meal = dao_meal;
        }

        @Override
        protected Void doInBackground(e_meal... e_meals) {
            dao_meal.update(e_meals[0]);
            return null;
        }
    }

}
