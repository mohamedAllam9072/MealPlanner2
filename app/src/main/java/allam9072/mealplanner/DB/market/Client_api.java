package allam9072.mealplanner.DB.market;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Client_api {
    @GET("categories")
    Call<List<Category_market>> getAllCategories();

    //    @GET("categories/{id}")
//    Call<List<Product>> getProducts(@Path("id") int id);
    @GET("categories/1")
    Call<List<Category_market>> getProducts();

}
