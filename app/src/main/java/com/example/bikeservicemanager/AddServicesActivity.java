package com.example.bikeservicemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

public class AddServicesActivity extends AppCompatActivity {

    FirebaseDatabase database;
    EditText serviceName;
    EditText serviceId;
    Button add;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_services);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        add = findViewById(R.id.addService);
        serviceId = findViewById(R.id.serviceId);
        serviceName = findViewById(R.id.serviceName);

        database =FirebaseDatabase.getInstance();


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Services s = new Services();
                s.setService_name(serviceName.getText().toString());
                s.setSid(serviceId.getText().toString());
                database.getReference().child("AllServices").child("3")
                        .setValue(s).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddServicesActivity.this, "Service added", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });




    }
}