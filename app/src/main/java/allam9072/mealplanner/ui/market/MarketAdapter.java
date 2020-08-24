package allam9072.mealplanner.ui.market;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import allam9072.mealplanner.DB.market.Category_market;
import allam9072.mealplanner.R;

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.mVH> {
    private List<Category_market> market_categories;
    private Context context;

    public MarketAdapter(List<Category_market> market_categories, Context context) {
        this.market_categories = market_categories;
        this.context = context;
    }


    @NonNull
    @Override
    public mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_market, parent, false);
        return new mVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mVH holder, int position) {
        holder.textView.setText(market_categories.get(position).getCat_name());
        try {
            Picasso.with(context)
                    .load(market_categories.get(position).getCat_image())
                    .placeholder(R.color.AQUA)
                    .error(R.color.white)
                    .fit()
                    .centerCrop()
                    .into(holder.imageView);
        } catch (Exception ignored) {
        }

    }

    @Override
    public int getItemCount() {
        return market_categories.size();
    }

    public class mVH extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public mVH(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_item_market);
            textView = itemView.findViewById(R.id.tv_item_market);
        }
    }
}
