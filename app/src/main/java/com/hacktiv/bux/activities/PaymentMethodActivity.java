package com.hacktiv.bux.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.hacktiv.bux.R;
import com.hacktiv.bux.activities.fragments.PaymentMethodFragment;

public class PaymentMethodActivity extends AppCompatActivity {

    private ImageButton backBtn;
    private PaymentMethodFragment paymentMethodFragment = new PaymentMethodFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.container, paymentMethodFragment).commit();
    }
}