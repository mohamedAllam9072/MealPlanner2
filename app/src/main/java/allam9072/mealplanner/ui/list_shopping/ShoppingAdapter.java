package allam9072.mealplanner.ui.list_shopping;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import allam9072.mealplanner.DB.m_Tables.ProductEntity;
import allam9072.mealplanner.R;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.mVH> {
    private List<ProductEntity> productList = new ArrayList<>();
    private ProductCLickListener listener;

    public ShoppingAdapter(ProductCLickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ShoppingAdapter.mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_product_linear, parent, false);
        return new mVH(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingAdapter.mVH holder, int position) {
        holder.textView1.setText(productList.get(position).getProduct_name());
        holder.textView2.setText("" + productList.get(position).getProduct_price());
        holder.textView3.setText("" + productList.get(position).getProduct_weight());
//        try {
//            String imageUrl = productList.get(position).getProd_image();
//            Picasso.with(context)
//                    .load(imageUrl)
//                    .error(R.drawable.food1)
//                    .fit()
//                    .centerCrop()
//                    .into(holder.imageView);
//        } catch (Exception ignored) {
//        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void setProducts(List<ProductEntity> products) {
        this.productList = products;
        notifyDataSetChanged();
    }

    public class mVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView1, textView2, textView3;
        ImageView imageView;
        ProductCLickListener listener;

        public mVH(@NonNull View itemView, ProductCLickListener listener) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.tv_1_product_linear);
            textView2 = itemView.findViewById(R.id.tv_2_product_linear);
            textView3 = itemView.findViewById(R.id.tv_3_product_linear);
            imageView = itemView.findViewById(R.id.iv_product_linear);
            this.listener = listener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            listener.click(getAdapterPosition());
            v.setBackgroundColor(R.color.FUCHSIA);
            v.setClickable(false);


        }
    }

    public interface ProductCLickListener {
        void click(int position);
    }
}
