package com.example.bikeservicemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;
import java.util.Objects;

public class ServiceDetails extends AppCompatActivity {
    EditText dateText ;
    ImageView cal;
    Button btnsubmit,btnbacktoadd;
    private int mDate,mMonth,mYear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_details);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Service Details");
        dateText = findViewById(R.id.date);
        cal=findViewById(R.id.datepicker);dateText = findViewById(R.id.date);
        cal=findViewById(R.id.datepicker);
        btnsubmit = findViewById(R.id.btnsubmit);
        btnbacktoadd = findViewById(R.id.btnbacktoadd);
        //@SuppressLint("ResourceType")
        //String []demo= getResources().getStringArray(R.array.str_demo);

        cal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                final Calendar Cal = Calendar.getInstance();
                mDate = Cal.get(Calendar.DATE);
                mMonth= Cal.get(Calendar.MONTH);
                mYear=Cal.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(ServiceDetails.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                        dateText.setText(date+"-"+month+"-"+year);
                    }
                },mYear,mMonth,mDate);
                datePickerDialog.show();
            }
        });

        btnbacktoadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ServiceDetails.this,customerDetails.class);
                startActivity(i);
            }
        });
    }
}