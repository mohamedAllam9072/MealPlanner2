package allam9072.mealplanner.ui.planWeek;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import allam9072.mealplanner.DB.m_Tables.MealEntity;
import allam9072.mealplanner.DB.m_Tables.MealProductsRelation;
import allam9072.mealplanner.DB.m_Tables.ProductEntity;
import allam9072.mealplanner.R;
import allam9072.mealplanner.ui.planMeal.MealPlanActivity;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class NestedAdapter extends RecyclerView.Adapter<NestedAdapter.mVH> {
    private Context context;
    private List<MealEntity> meals;
    private List<ProductEntity> products = new ArrayList<>();
    private WeekViewModel viewModel;
    private LifecycleOwner lifecycleOwner;

    public NestedAdapter(Context context, List<MealEntity> meals) {
        this.context = context;
        this.meals = meals;
    }

    @NonNull
    @Override
    public NestedAdapter.mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_meal_products, parent, false);
        return new mVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NestedAdapter.mVH holder, final int position) {

        holder.tv_mealTitle.setText(meals.get(position).getMeal_name());
        holder.tv_mealProducts.setText("time");

//        viewModel.getMealProducts(meals.get(position).getMealId())
//                .observe(lifecycleOwner, new Observer<List<MealProductsRelation>>() {
//                    @Override
//                    public void onChanged(List<MealProductsRelation> mealProducts) {
//                        setProducts(mealProducts.get(0).products);
//                        String s = " ";
//                        for (int i = 0; i < products.size(); i++) {
//                            s += products.get(i).getProduct_name() + " ";
//
//                        }
//                        holder.tv_mealProducts.setText(s);
//                    }
//                });




    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public void setViewModel(WeekViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    public class mVH extends RecyclerView.ViewHolder {
        TextView tv_mealTitle, tv_mealProducts;

        public mVH(@NonNull View itemView) {
            super(itemView);
            tv_mealTitle = itemView.findViewById(R.id.tv_mealTitle);
            tv_mealProducts = itemView.findViewById(R.id.tv_mealProducts);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MealPlanActivity.class);
                    intent.putExtra("mealId", meals.get(getAdapterPosition()).getMealId());
                    intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                    Toast.makeText(context, " NestedAdapter", Toast.LENGTH_SHORT).show();
                }
            });


        }
    }
}
