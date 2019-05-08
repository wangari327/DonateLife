package com.example.silver_tech.donatelife.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.silver_tech.donatelife.R;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {
    TextView descriptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void goToDonationPage(View view) {
        descriptor = findViewById(R.id.descptor_text);
        descriptor.setText(getText(R.string.transplantation));
        descriptor.setVisibility(View.VISIBLE);
    }

    public void goToLaw(View view) {
        TextView descriptor = findViewById(R.id.descptor_text);
        descriptor.setText(getText(R.string.law));
        descriptor.setVisibility(View.VISIBLE);
    }

    public void goToSaver(View view) {
        TextView descriptor = findViewById(R.id.descptor_text);
        descriptor.setText(getText(R.string.life_saver));
        descriptor.setVisibility(View.VISIBLE);
    }

    public void goToLiving(View view) {
        TextView descriptor = findViewById(R.id.descptor_text);
        descriptor.setText(getText(R.string.living));
        descriptor.setVisibility(View.VISIBLE);
    }

//    public void goToAnActivity2(View view) {
//        Intent intent = new Intent(this,DonorListActivity.class);
//        startActivity(intent);
//    }
}
