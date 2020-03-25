package allam9072.mealplanner.ui.ListActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import allam9072.mealplanner.DB.Product;
import allam9072.mealplanner.R;
import allam9072.mealplanner.ui.product_profile.ProductProfileActivity;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.mVH> {
    private Context context;
    private List<Product> list;

    public ListAdapter(Context context, List<Product> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_product_2, parent, false);
        return new mVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mVH holder, int position) {
        holder.tv_title.setText(list.get(position).getProd_name());
        holder.tv_secondText.setText(list.get(position).getProd_price());
        holder.tv_thirdText.setText(list.get(position).getProd_weight());
        try {
            Picasso.with(context)
                    .load(list.get(position).getProd_image())
                    //  .placeholder(R.mipmap.ic_launcher)
                    .error(R.drawable.food1)
                    .fit()
                    .centerCrop()
                    .into(holder.imageView);
        } catch (Exception ignored) {
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class mVH extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tv_title, tv_secondText, tv_thirdText;
        CardView cardView;

        public mVH(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_product);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_secondText = itemView.findViewById(R.id.tv_second_text);
            tv_thirdText = itemView.findViewById(R.id.tv_third_text);
            cardView = itemView.findViewById(R.id.cardView_categoryItem);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ProductProfileActivity.class);
                    intent.putExtra("prod_title", list.get(getAdapterPosition()).getProd_name());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });


        }
    }
}
