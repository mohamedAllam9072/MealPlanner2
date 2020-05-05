package allam9072.mealplanner.ui.list_grocery;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import allam9072.mealplanner.DB.m_Tables.MealProductsRelation;
import allam9072.mealplanner.R;
import allam9072.mealplanner.ui.product_profile.ProductProfileActivity;

public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.mVH> {
    private List<MealProductsRelation> productList = new ArrayList<>();
    private Context context;

    public GroceryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GroceryAdapter.mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_product_linear, parent, false);
        return new mVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryAdapter.mVH holder, int position) {
        holder.textView1.setText(productList.get(position).products.get(position).getProduct_name());
        holder.textView2.setText("" + productList.get(position).products.get(position).getProduct_price());
        holder.textView3.setText("" + productList.get(position).products.get(position).getProduct_weight());
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

    public void setProducts(List<MealProductsRelation> products) {
        this.productList = products;
        notifyDataSetChanged();
    }

    public class mVH extends RecyclerView.ViewHolder {
        TextView textView1, textView2, textView3;
        ImageView imageView;

        public mVH(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.tv_1_product_linear);
            textView2 = itemView.findViewById(R.id.tv_2_product_linear);
            textView3 = itemView.findViewById(R.id.tv_3_product_linear);
            imageView = itemView.findViewById(R.id.iv_product_linear);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ProductProfileActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }
    }
}
