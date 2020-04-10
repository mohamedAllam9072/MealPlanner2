package allam9072.mealplanner.ui.list_weeks;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import allam9072.mealplanner.DB.m_Tables.WeekEntity;
import allam9072.mealplanner.R;
import allam9072.mealplanner.ui.planWeek.WeekActivity;

public class WeeksFragment extends Fragment {
    private WeeksViewModel viewModel;
    private WeeksAdapter adapter = new WeeksAdapter();
    private RecyclerView recyclerView;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_weeks, container, false);

        recyclerView = root.findViewById(R.id.rv_weeks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(WeeksViewModel.class);
        viewModel.getAllWeeks().observe(getViewLifecycleOwner(), new Observer<List<WeekEntity>>() {
            @Override
            public void onChanged(List<WeekEntity> WeekEntities) {
                adapter.setWeeks(WeekEntities);
            }
        });

        Button btn_new_week_plan = root.findViewById(R.id.btn_add_week_plan);
        btn_new_week_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), WeekActivity.class);
                startActivity(intent);
            }
        });
        adapter.setListener(new WeeksAdapter.listener() {
            @Override
            public void click(WeekEntity week) {
                Intent intent = new Intent(getContext(), WeekActivity.class);
                intent.putExtra("week_id", week.getWeekId());
                Toast.makeText(getContext(), String.valueOf(week.getWeekId()), Toast.LENGTH_SHORT).show();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().startActivity(intent);
            }
        });


        return root;
    }
}