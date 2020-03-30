package allam9072.mealplanner.ui.planMeal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

import allam9072.mealplanner.DB.m_Tables.MealProductsRelation;
import allam9072.mealplanner.DB.m_Tables.ProductEntity;
import allam9072.mealplanner.R;
import allam9072.mealplanner.ui.product_profile.ProductProfileActivity;

public class MealPlanNestedAdapter extends RecyclerView.Adapter<MealPlanNestedAdapter.mVH> {
    private Context context;
    private List<ProductEntity> mealProductsList = new ArrayList<>();


    public MealPlanNestedAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_product_name, parent, false);
        return new mVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mVH holder, int position) {
        holder.textView.setText(mealProductsList.get(position).getProduct_name());

    }

    public void setMealProductsList(List<ProductEntity> mealProductsList) {
        this.mealProductsList = mealProductsList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mealProductsList.size();
    }

    public class mVH extends RecyclerView.ViewHolder {
        TextView textView;
        MaterialCardView cardView;

        public mVH(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_product_title);
            cardView = itemView.findViewById(R.id.cardView_product_title);
            cardView.setOnClickListener(new View.OnClickListener() {
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
