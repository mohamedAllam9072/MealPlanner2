package allam9072.mealplanner.DB.m_Tables;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ProductEntity implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int productId;
    private String product_name;
    private int product_price;
    private int product_weight;

    public ProductEntity(String product_name, int product_price, int product_weight) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_weight = product_weight;
    }

    protected ProductEntity(Parcel in) {
        productId = in.readInt();
        product_name = in.readString();
        product_price = in.readInt();
        product_weight = in.readInt();
    }

    public static final Creator<ProductEntity> CREATOR = new Creator<ProductEntity>() {
        @Override
        public ProductEntity createFromParcel(Parcel in) {
            return new ProductEntity(in);
        }

        @Override
        public ProductEntity[] newArray(int size) {
            return new ProductEntity[size];
        }
    };

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public String getProduct_name() {
        return product_name;
    }

    public int getProduct_price() {
        return product_price;
    }

    public int getProduct_weight() {
        return product_weight;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(productId);
        dest.writeString(product_name);
        dest.writeInt(product_price);
        dest.writeInt(product_weight);
    }
}
