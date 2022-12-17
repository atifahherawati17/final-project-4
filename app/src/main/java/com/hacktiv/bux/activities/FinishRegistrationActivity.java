package com.hacktiv.bux.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hacktiv.bux.R;

public class FinishRegistrationActivity extends AppCompatActivity {

    Button takeMeToBuxBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_registration);

        takeMeToBuxBtn = findViewById(R.id.takeMeToBux);

        takeMeToBuxBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent;
                intent = new Intent(FinishRegistrationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}