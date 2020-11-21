package allam9072.mealplanner.DB.market;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Category_market {

    @SerializedName("id")
    private int cat_id;
    @SerializedName("name")
    private String cat_name;
    @SerializedName("category_img")
    private String cat_image;
    @SerializedName("products")
    private List<Product_market> products;

    public int getCat_id() {
        return cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public String getCat_image() {
        return cat_image;
    }

    public List<Product_market> getProducts() {
        return products;
    }
}
