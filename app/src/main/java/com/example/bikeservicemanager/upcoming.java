package com.example.bikeservicemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class upcoming extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);
        getSupportActionBar().setTitle("Upcoming Services");
    }
}