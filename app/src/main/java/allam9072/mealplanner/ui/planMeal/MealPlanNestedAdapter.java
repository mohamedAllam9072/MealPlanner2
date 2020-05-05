package allam9072.mealplanner.ui.planMeal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import allam9072.mealplanner.DB.m_Tables.ProductEntity;
import allam9072.mealplanner.R;
import allam9072.mealplanner.ui.product_profile.ProductProfileActivity;

public class MealPlanNestedAdapter extends RecyclerView.Adapter<MealPlanNestedAdapter.mVH> {
    private Context context;
    private List<ProductEntity> mealProductsList = new ArrayList<>();
    private deleteListener deleteListener;


    public MealPlanNestedAdapter(Context context, deleteListener deleteListener) {
        this.context = context;
        this.deleteListener = deleteListener;
    }

    @NonNull
    @Override
    public mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_product_name, parent, false);
        return new mVH(view, deleteListener);
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

    public interface deleteListener {
        void delete_click(int position);
    }

    public class mVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;
        ImageButton imageButton;
        deleteListener deleteListener;

        public mVH(@NonNull View itemView, deleteListener deleteListener) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_product_title);
            imageButton = itemView.findViewById(R.id.btn_delete_product);
            this.deleteListener = deleteListener;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ProductProfileActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
            imageButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            deleteListener.delete_click(getAdapterPosition());

        }
    }

}
