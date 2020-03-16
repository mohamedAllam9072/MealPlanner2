package allam9072.mealplanner.DB.m_Tables;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class e_product implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int _id_product;
    private String product_name;
    private int product_price;
    private int product_weight;

    public e_product(String product_name, int product_price, int product_weight) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_weight = product_weight;
    }

    protected e_product(Parcel in) {
        _id_product = in.readInt();
        product_name = in.readString();
        product_price = in.readInt();
        product_weight = in.readInt();
    }

    public static final Creator<e_product> CREATOR = new Creator<e_product>() {
        @Override
        public e_product createFromParcel(Parcel in) {
            return new e_product(in);
        }

        @Override
        public e_product[] newArray(int size) {
            return new e_product[size];
        }
    };

    public void set_id_product(int _id_product) {
        this._id_product = _id_product;
    }

    public int get_id_product() {
        return _id_product;
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
        dest.writeInt(_id_product);
        dest.writeString(product_name);
        dest.writeInt(product_price);
        dest.writeInt(product_weight);
    }
}
