package com.example.bikeservicemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class customerDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);
        getSupportActionBar().setTitle("Customer Details");
    }
}