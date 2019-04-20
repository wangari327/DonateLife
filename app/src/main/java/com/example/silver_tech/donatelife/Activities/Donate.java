package com.example.silver_tech.donatelife.Activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.silver_tech.donatelife.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;

public class Donate extends AppCompatActivity {

    //we will use these constants later to pass the artist name and id to another activity
    public static final String DONOR_NAME = "com.example.silver_tech.donatelife.donorname";
    public static final String DONOR_ID = "com.example.silver_tech.donatelife.donorid";

    //view objects
    TextInputEditText editTextName, editTextPhone;
    EditText editTextDob;
    Spinner spinnerGender, spinnerOrgans, spinnerCounty, spinnerBlood;
    Button buttonAddDonor;
    ListView listViewDonors;

    //our database reference object
    DatabaseReference databaseDonors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        //getting the reference of artists node
        databaseDonors = FirebaseDatabase.getInstance().getReference("donors");
        //getting views
        editTextName = findViewById(R.id.donor_name);
        editTextDob = findViewById(R.id.dob);

        editTextPhone = findViewById(R.id.phone);
        spinnerGender = findViewById(R.id.gender_spinner);
        spinnerOrgans = findViewById(R.id.organs_spinner);
        spinnerCounty = findViewById(R.id.county_spinner);
        spinnerBlood = findViewById(R.id.blood_spinner);


        buttonAddDonor = findViewById(R.id.buttonAddDonor);

        //adding an onclick to button
        buttonAddDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                addDonor();
            }
        });
    }

    private void addDonor() {
        //getting the values to save
        String name = editTextName.getText().toString().trim();
        String phone = editTextDob.getText().toString().trim();
        String dob = editTextPhone.getText().toString().trim();
        String gender = spinnerGender.getSelectedItem().toString();
        String organ = spinnerOrgans.getSelectedItem().toString();
        String county = spinnerCounty.getSelectedItem().toString();
        String blood = spinnerBlood.getSelectedItem().toString();

        //checking if the value is provided
        if (!TextUtils.isEmpty(name)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Donor
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            String id = Objects.requireNonNull(mAuth.getCurrentUser()).getDisplayName();

            //creating a Donors Object
            Donors donor = new Donors(id,name,gender,dob,phone,organ,county,blood);

            //Saving the Donor
            databaseDonors.child(Objects.requireNonNull(id)).setValue(donor);

            //setting editText to blank again
            editTextName.setText("");
            editTextPhone.setText("");
            editTextDob.setText("");

            //displaying a success toast
            Toast.makeText(this,"Done! Thank you for donating",Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this,"Please enter a name",Toast.LENGTH_LONG).show();
        }
    }

}
