package com.hacktiv.bux.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hacktiv.bux.R;

public class OrderActivity extends AppCompatActivity {

    ImageView backBtn;
    RelativeLayout detailLayoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        backBtn = findViewById(R.id.backBtn);
        detailLayoutBtn = findViewById(R.id.detailLayoutBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               onBackPressed();
            }
        });

        detailLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent;
                intent = new Intent(OrderActivity.this, OrderDetailActivity.class);
                startActivity(intent);
            }
        });
    }
}