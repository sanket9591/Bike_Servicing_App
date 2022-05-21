package com.example.bikeservicemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.Objects;

public class ServiceDetails extends AppCompatActivity {
    EditText dateText ;
    ImageView cal;
    Button btnsubmit,btnbacktoadd,serviceAdd;
    CheckBox ch;
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
//        ch=findViewById(R.id.checkBox1);
        //@SuppressLint("ResourceType")
        //String []demo= getResources().getStringArray(R.array.str_demo);

        serviceAdd = findViewById(R.id.serviceAddIntent);

        serviceAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ServiceDetails.this,AddServicesActivity.class));
            }
        });

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


        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseDatabase database = FirebaseDatabase.getInstance();





        database.getReference().child("AllServices").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot s:snapshot.getChildren()){
                    Services service = s.getValue(Services.class);

                    LinearLayout ll = (LinearLayout)findViewById(R.id.myLay);

                    //add checkboxes

                        CheckBox cb = new CheckBox(ServiceDetails.this);
                        cb.setText(service.getService_name());
                        cb.setId(Integer.parseInt(service.getSid()));
                        ll.addView(cb);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





//        DocumentReference document = db.document("Allservice");
//        document.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                if(documentSnapshot.exists())
//                {
//                    ch.setText(documentSnapshot.getString("service_name"));
//                }
//                else
//                {
//                    Toast.makeText(getApplicationContext(), "Row not found", Toast.LENGTH_SHORT).show();
//                }
//            }
//        })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
//                    }
//                });


        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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