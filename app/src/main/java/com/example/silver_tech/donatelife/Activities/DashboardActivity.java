package com.example.silver_tech.donatelife.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.silver_tech.donatelife.R;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void goToDonationPage(View view) {
        Intent intent = new Intent(this,Donate.class);
        startActivity(intent);
    }

//    public void goToAnActivity2(View view) {
//        Intent intent = new Intent(this,DonorListActivity.class);
//        startActivity(intent);
//    }
}
