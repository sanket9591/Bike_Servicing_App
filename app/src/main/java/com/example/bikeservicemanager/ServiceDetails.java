package com.example.bikeservicemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;

public class ServiceDetails extends AppCompatActivity {
    EditText dateText ;
    ImageView cal;
    private int mDate,mMonth,mYear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_details);
        dateText = findViewById(R.id.date);
        cal=findViewById(R.id.datepicker);dateText = findViewById(R.id.date);
        cal=findViewById(R.id.datepicker);

        cal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                final Calendar Cal = Calendar.getInstance();
                mDate = Cal.get(Calendar.DATE);
                mMonth= Cal.get(Calendar.MONTH);
                mYear=Cal.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(ServiceDetails.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                        dateText.setText(date+"-"+month+"-"+year);
                    }
                },mYear,mMonth,mDate);
                datePickerDialog.show();
            }
        });
    }
}