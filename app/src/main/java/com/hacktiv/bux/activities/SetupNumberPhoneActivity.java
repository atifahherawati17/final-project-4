package com.hacktiv.bux.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hacktiv.bux.R;

public class SetupNumberPhoneActivity extends AppCompatActivity {

    Button saveNumberBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_number_phone);

        saveNumberBtn = findViewById(R.id.saveNumberBtn);

        saveNumberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent;
                intent = new Intent(SetupNumberPhoneActivity.this, FinishRegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}