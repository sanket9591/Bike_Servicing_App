package com.example.bikeservicemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class customerDetails extends AppCompatActivity {
    String[] languages = {"Hero", "Honda", "Yamaha", "Kawasaki", "TVS", "Bajaj", "Royal Enfield", "Suzuki"};
    private EditText txt_name, txt_contact, txt_Bike_Manufacturer, txt_Bike_model, txt_Build_Year, txt_Bike_No, txt_Daily_Running, txt_address;
    private Button add;
   // private MySQLiteOpenHelper mySQLiteOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_customer_details);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Customer Details");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice, languages);
        //Find TextView control
        AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.editTextBikeManufacturer);
        //Set the number of characters the user must type before the drop down list is shown
        acTextView.setThreshold(1);
        //Set the adapter
        acTextView.setAdapter(adapter);
        txt_name = findViewById(R.id.editTextPersonName);
        txt_contact = findViewById(R.id.editTextContact);
        txt_Bike_Manufacturer = findViewById(R.id.editTextBikeManufacturer);
        txt_Bike_model = findViewById(R.id.editTextBikemodel);
        txt_Build_Year = findViewById(R.id.editTextbuildyear);
        txt_Bike_No = findViewById(R.id.editTextbikeno);
        txt_Daily_Running = findViewById(R.id.editTextdailyrunning);
        txt_address = findViewById(R.id.editTextaddress);
        add = findViewById(R.id.btnadd);
        //mySQLiteOpenHelper = new MySQLiteOpenHelper(customerDetails.this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txt_name.getText().toString();
                String contact = txt_contact.getText().toString();
                String bm = txt_Bike_Manufacturer.getText().toString();
                String bmodel = txt_Bike_model.getText().toString();
                String byear = txt_Build_Year.getText().toString();
                String bno = txt_Bike_No.getText().toString();
                String dailyrunning = txt_Daily_Running.getText().toString();
                String address = txt_address.getText().toString();


             /*   Map<String,Object> Service_Details= new HashMap<>();
                Service_Details.put("cid","1");
                Service_Details.put("sid","1");
                Service_Details.put("Date","01-11-2001");
                Service_Details.put("nextDate","01-11-2002");


                Map<String,Object> All_Services= new HashMap<>();
                Service_Details.put("sid","1");
                Service_Details.put("services","oil change");
                Service_Details.put("sid","2");
                Service_Details.put("services","Chain lubrication");
                Service_Details.put("sid","3");
                Service_Details.put("services","Tire checking");
                Service_Details.put("sid","3");
                Service_Details.put("services","Brake checking");

*/

                if (name.isEmpty() && contact.isEmpty() && bm.isEmpty() && bmodel.isEmpty() && byear.isEmpty() && bno.isEmpty() && dailyrunning.isEmpty() && address.isEmpty()) {
                    Toast.makeText(customerDetails.this, "Please enter all the Filed", Toast.LENGTH_SHORT).show();
                }

                CustomerDetailsHelper customerDetailsHelper = new CustomerDetailsHelper(
                        name, contact, bm, bmodel, byear, bno, dailyrunning, address
                );

                FirebaseFirestore db = FirebaseFirestore.getInstance();
                db.collection("Users")
                        .document(customerDetailsHelper.getName())
                        .set(customerDetailsHelper)
                        .addOnFailureListener(e -> Toast.makeText(customerDetails.this, "User Add Failed !!", Toast.LENGTH_SHORT).show())
                        .addOnSuccessListener(unused -> Toast.makeText(customerDetails.this, "User Added", Toast.LENGTH_SHORT).show());




             //   FirebaseFirestore db = FirebaseFirestore.getInstance();

               /*db.collection("Service_Details")
                        .add(Service_Details)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(customerDetails.this, "Data saved", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(customerDetails.this, "Data failed", Toast.LENGTH_SHORT).show();
                    }
                });*/


               // db.collection("AllServices");
                      //  .addOnFailureListener(e -> Toast.makeText(customerDetails.this, "User Add Failed !!", Toast.LENGTH_SHORT).show())
                      //  .addOnSuccessListener(unused -> Toast.makeText(customerDetails.this, "User Added", Toast.LENGTH_SHORT).show());

                //mySQLiteOpenHelper.insertRecord(name,contact,bm,bmodel,byear,bno,dailyrunning,address);
               // Toast.makeText(customerDetails.this, "Record Inserted", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(customerDetails.this, ServiceDetails.class);
                startActivity(i);
            }
        });
    }
}