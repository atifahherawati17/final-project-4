package com.hacktiv.bux.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hacktiv.bux.R;

public class BusScheduleActivity extends AppCompatActivity {

    Button bookNowBtn;
    RelativeLayout departureLayout, arrivalLayout;
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_schedule);

        bookNowBtn = findViewById(R.id.book_now_btn);
        departureLayout = (RelativeLayout) findViewById(R.id.departureLayout);
        arrivalLayout = (RelativeLayout) findViewById(R.id.arrivalLayout);
        backBtn = findViewById(R.id.backBtn);

        bookNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent;
                intent = new Intent(BusScheduleActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        bookNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent;
                intent = new Intent(BusScheduleActivity.this, BusDetail.class);
                startActivity(intent);
            }
        });

        departureLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent;
            intent = new Intent(BusScheduleActivity.this, SearchDepartureActivity.class);
            startActivity(intent);
            }
        });

        arrivalLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent;
                intent = new Intent(BusScheduleActivity.this, SearchDestinationActivity.class);
                startActivity(intent);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}