package com.hacktiv.bux.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.hacktiv.bux.R;

public class LoginActivity extends AppCompatActivity {

    RelativeLayout relativeLayoutBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        relativeLayoutBtn = findViewById(R.id.relativeLayoutBtn);

        relativeLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent;
                intent = new Intent(LoginActivity.this, SetupNumberPhoneActivity.class);
                startActivity(intent);
            }
        });
    }
}