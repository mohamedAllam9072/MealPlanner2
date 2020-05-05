package allam9072.mealplanner.ui.planWeek;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

import allam9072.mealplanner.DB.m_Tables.WeekDaysRelation;
import allam9072.mealplanner.R;

public class WeekActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private int weekId;
    private RecyclerView recyclerView;
    private WeekAdapter adapter;
    private NestedAdapter nestedAdapter;
    private WeekViewModel viewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_plan);

        init();

        viewModel.getWeekDays(weekId).observe(this, new Observer<List<WeekDaysRelation>>() {
            @Override
            public void onChanged(List<WeekDaysRelation> weekDays) {
                adapter.setWeekDays(weekDays.get(0).days);
                getSupportActionBar().setTitle(weekDays.get(0).week.getWeek_name().toUpperCase()
                        + "         " + weekDays.get(0).week.getWeek_date());
            }
        });
        adapter.setViewModel(viewModel);
        adapter.setLifecycleOwner(this);
    }

    private void init() {
        //views
        recyclerView = findViewById(R.id.rv_week_plan);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new WeekAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);
        //data
        viewModel = new ViewModelProvider(this).get(WeekViewModel.class);
        Intent intent = getIntent();
        weekId = intent.getIntExtra("week_id", 1);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_week, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_weekTitle:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                View view = getLayoutInflater().inflate(R.layout.dialog_meal_title, null);
                final TextInputEditText editText = view.findViewById(R.id.editText_mealTitle);
                builder.setView(view)
                        .setTitle("Week Title")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setTitle(editText.getText().toString());
                            }
                        })
                        .setNegativeButton("no", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(WeekActivity.this, "no", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create()
                        .show();

                break;
            case R.id.menu_item_weekDate:
                DatePickerFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String dateString = DateFormat.getDateInstance().format(calendar.getTime());
        getSupportActionBar().setTitle(dateString);


    }
}
