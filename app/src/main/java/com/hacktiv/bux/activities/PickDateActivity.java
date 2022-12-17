package com.hacktiv.bux.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;

import com.hacktiv.bux.R;
import com.hacktiv.bux.activities.fragments.SearchFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PickDateActivity extends AppCompatActivity {

    private ImageButton backBtn;
    private Button selectDateBtn;
    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_date);

        backBtn = findViewById(R.id.backBtn);
        selectDateBtn = findViewById(R.id.selectDateBtn);
        datePicker = findViewById(R.id.datePicker);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        selectDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int   day  = datePicker.getDayOfMonth();
                int   month= datePicker.getMonth();
                int   year = datePicker.getYear();

                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);

                SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM");
                String formatedDate = sdf.format(calendar.getTime());

                Bundle bundle = new Bundle();
                bundle.putString("date", formatedDate);

                SearchFragment searchFragment = new SearchFragment();
                searchFragment.setArguments(bundle);

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("date", formatedDate);
                i.putExtra("passengers", getIntent().getStringExtra("passengers"));
                startActivity(i);
                finish();

            }
        });
    }
}