package allam9072.mealplanner.ui.planWeek;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
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

import allam9072.mealplanner.DB.m_Tables.DayEntity;
import allam9072.mealplanner.DB.m_Tables.MealProductsRelation;
import allam9072.mealplanner.R;
import allam9072.mealplanner.ui.planDay.DayPlanActivity;
public class WeekActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private int receivedWeekId;
    private RecyclerView recyclerView;
    private WeekAdapter adapter;
    private WeekViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_plan);
        adapter = new WeekAdapter(getApplicationContext());
        viewModel = new ViewModelProvider(this).get(WeekViewModel.class);
        viewModel.getDays().observe(this, new Observer<List<DayEntity>>() {
            @Override
            public void onChanged(List<DayEntity> days) {
                adapter.setDays(days);
            }
        });
        viewModel.getMeal_products().observe(this, new Observer<List<MealProductsRelation>>() {
            @Override
            public void onChanged(List<MealProductsRelation> mealProducts) {
                adapter.setMeal_products(mealProducts);
            }
        });

        recyclerView = findViewById(R.id.rv_week_plan);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setListener(new WeekAdapter.listener() {
            @Override
            public void click(DayEntity day) {
                Intent intent = new Intent(getApplicationContext(), DayPlanActivity.class);
                intent.putExtra("dayTitle", day.getDay_name());
                intent.putExtra("day_id", day.getDayId());
                startActivity(intent);
            }
        });
    }

    private void SaveWeekPlan() {
        /**
         * OUTPUT : save week plan
         * INPUT : get All week data {id ,name, start date,days[]}
         *
         * */
        Button btn_save = findViewById(R.id.btn_save_week_plan);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }

    private void getWeekId() {
        Intent intent = getIntent();
        receivedWeekId = intent.getIntExtra("week_id", 0);

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
        TextView tv_Date = findViewById(R.id.tv_date);
        tv_Date.setText(dateString);

    }
}
