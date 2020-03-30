package allam9072.mealplanner.ui.planMeal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import allam9072.mealplanner.DB.m_Tables.ProductEntity;
import allam9072.mealplanner.R;

public class MealPlanAdapter extends RecyclerView.Adapter<MealPlanAdapter.mVH> {
    private List<ProductEntity> productsList = new ArrayList<>();
    private mOnClickListener mOnClickListener;

    public MealPlanAdapter(mOnClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

    @NonNull
    @Override
    public mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_product_name, parent, false);
        return new mVH(view, mOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull mVH holder, int position) {
        holder.textView.setText(productsList.get(position).getProduct_name());


    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    /**
     * this method refer to observes in Main_activity view_model calling
     */
    public void setProducts(List<ProductEntity> products) {
        this.productsList = products;
        notifyDataSetChanged();
    }

    public interface mOnClickListener {
        void click(int position);
    }

    public class mVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;
        private mOnClickListener mOnClickListener;

        public mVH(@NonNull View itemView, mOnClickListener mOnClickListener) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_product_title);
            this.mOnClickListener = mOnClickListener;
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            mOnClickListener.click(position);
            v.setVisibility(View.GONE);
        }
    }
}
