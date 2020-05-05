package allam9072.mealplanner.ui.list_weeks;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import allam9072.mealplanner.DB.m_Tables.WeekEntity;
import allam9072.mealplanner.R;

public class WeeksAdapter extends RecyclerView.Adapter<WeeksAdapter.mVH> {
    private List<WeekEntity> weeksList = new ArrayList<>();
    private listener listener;

    @NonNull
    @Override
    public mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_weeks_view, parent, false);
        return new mVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mVH holder, int position) {
        holder.textView1.setText(weeksList.get(position).getWeek_name());
        holder.textView2.setText(weeksList.get(position).getWeek_date());
    }
    public void setWeeks(List<WeekEntity> weeks) {
        this.weeksList = weeks;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return weeksList.size();
    }

    public class mVH extends RecyclerView.ViewHolder {
        TextView textView1, textView2;

        public mVH(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.tv_weekTitle);
            textView2 = itemView.findViewById(R.id.tv_weekStartDate);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.click(weeksList.get(getAdapterPosition()));
                }
            });

        }
    }


    public interface listener {
        void click(WeekEntity week);
    }

    public void setListener(WeeksAdapter.listener listener) {
        this.listener = listener;
    }
}
