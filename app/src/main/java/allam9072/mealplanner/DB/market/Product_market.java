package allam9072.mealplanner.DB.market;

import com.google.gson.annotations.SerializedName;

public class Product_market {
    @SerializedName("id")
    private int prod_id;
    @SerializedName("product_img")
    private String prod_image;
    @SerializedName("name")
    private String prod_name;
    @SerializedName("weight")
    private String prod_weight;
    @SerializedName("price")
    private String prod_price;
    //  private int image;

//    public Product(int prod_image, String prod_name, String prod_weight, String prod_price) {
//        this.image = prod_image;
//        this.prod_name = prod_name;
//        this.prod_weight = prod_weight;
//        this.prod_price = prod_price;
//    }

    public String getProd_name() {
        return prod_name;
    }

    public String getProd_weight() {
        return prod_weight;
    }

    public String getProd_price() {
        return prod_price;
    }

    public String getProd_image() {
        return prod_image;
    }
}
