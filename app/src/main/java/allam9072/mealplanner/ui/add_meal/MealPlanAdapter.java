package allam9072.mealplanner.ui.add_meal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import allam9072.mealplanner.DB.m_Tables.e_product;
import allam9072.mealplanner.R;

public class MealPlanAdapter extends RecyclerView.Adapter<MealPlanAdapter.mVH> {
    private List<e_product> list1 = new ArrayList<>();
    //   private List<e_product> list2 ;
    private click_interface click_interface;

    public MealPlanAdapter(click_interface click_interface) {
        this.click_interface = click_interface;
        // list2 = new ArrayList<>(list1);
    }

    @NonNull
    @Override
    public mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_product, parent, false);
        return new mVH(view, click_interface);
    }

    @Override
    public void onBindViewHolder(@NonNull mVH holder, int position) {
        holder.textView.setText(list1.get(position).getProduct_name());



    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class mVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;
        private click_interface click_interface;

        public mVH(@NonNull View itemView, click_interface click_interface) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_product_title);
            this.click_interface = click_interface;
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            click_interface.click(position);
            v.setVisibility(View.GONE);
        }
    }

    /**
     * this method refer to observes in Main_activity view_model calling
     */
    public void setProducts(List<e_product> products) {
        this.list1 = products;
        notifyDataSetChanged();
    }


    public interface click_interface {
        void click(int position);
    }

//    public Filter getFilter() {
//        return SearchFilter;
//    }
//
//    private Filter SearchFilter = new Filter() {
//        ArrayList<e_product> filtered_list = new ArrayList<>();
//
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//            if (constraint == null || constraint.length() == 0) {
//                filtered_list.addAll(list2);
//            } else {
//                String filterPattern = constraint.toString().toLowerCase().trim();
//                for (e_product product_item : list2) {
//                    if (product_item.getProduct_name().toLowerCase().contains(filterPattern)) {
//                        filtered_list.add(product_item);
//                    }
//                }
//            }
//            FilterResults results = new FilterResults();
//            results.values = filtered_list;
//            return results;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults results) {
//            list1.clear();
//            list1.addAll((List) results.values);
//            notifyDataSetChanged();
//        }
//
//    };
}
