package allam9072.mealplanner.DB;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonAPI {
    @GET("categories")
    Call<List<Category>> getAllCategories();

    //    @GET("categories/{id}")
//    Call<List<Product>> getProducts(@Path("id") int id);
    @GET("categories/1")
    Call<List<Category>> getProducts();

}
