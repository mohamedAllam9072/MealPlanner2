package allam9072.mealplanner.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import allam9072.mealplanner.DB.Category;
import allam9072.mealplanner.R;
import allam9072.mealplanner.ui.ListActivity.ListActivity;

public class adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int ITEM1 = 1;
    public static final int ITEM2 = 2;
    Context context;
    List<Category> list;

    public adapter(Context context, List<Category> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == ITEM1) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_rv_category, parent, false);
            return new Item1_VH(view);
        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_rv_2_homefrag, parent, false);
            return new Item2_VH(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == ITEM1) {
            ((Item1_VH) holder).tv_categoryTitle.setText(list.get(position).getCat_name());

            try {
                String imageUrl = list.get(position).getCat_image();
                Picasso.with(context)
                        .load(imageUrl)
                        .error(R.drawable.food1)
                        .fit()
                        .centerCrop()
                        .into(((Item1_VH) holder).iv_cat_image);
            } catch (Exception ignored) {
            }
        } else {
            ((Item2_VH) holder).tv3.setText(list.get(position).getCat_name());
            try {
                String imageUrl = list.get(position).getCat_image();
                Picasso.with(context)
                        .load(imageUrl)
                        .error(R.drawable.food1)
                        .fit()
                        .centerCrop()
                        .into(((Item2_VH) holder).imageView2);
            } catch (Exception ignored) {
            }
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 2) {
            return ITEM2;
        } else
            return ITEM1;
    }

    class Item1_VH extends RecyclerView.ViewHolder {
        TextView tv_categoryTitle;
        ImageView iv_cat_image;
        CardView cardView;

        public Item1_VH(@NonNull View itemView) {
            super(itemView);
            tv_categoryTitle = itemView.findViewById(R.id.tv_title_category);
            iv_cat_image = itemView.findViewById(R.id.iv_category);
            cardView = itemView.findViewById(R.id.cardView_categoryItem);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ListActivity.class);
                    intent.putExtra("cat_title", list.get(getAdapterPosition()).getCat_name());
                    intent.putExtra("cat_id", list.get(getAdapterPosition()).getCat_id());
                    context.startActivity(intent);

                }
            });

        }
    }

    class Item2_VH extends RecyclerView.ViewHolder {
        TextView tv3;
        ImageView imageView2;
        LinearLayout linearLayout;

        public Item2_VH(@NonNull View itemView) {
            super(itemView);
            tv3 = itemView.findViewById(R.id.tv_2);
            imageView2 = itemView.findViewById(R.id.iv_category_item2);
            linearLayout = itemView.findViewById(R.id.view_linearLayout);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ListActivity.class);
                    intent.putExtra("cat_title", list.get(getAdapterPosition()).getCat_name());
                    intent.putExtra("cat_id", list.get(getAdapterPosition()).getCat_id());
                    context.startActivity(intent);
                }
            });

        }
    }
}
