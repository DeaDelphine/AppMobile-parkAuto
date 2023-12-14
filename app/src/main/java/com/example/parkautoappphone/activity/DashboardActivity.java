package com.example.parkautoappphone.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.parkautoappphone.R;

public class DashboardActivity extends AppCompatActivity {
TextView welcome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        welcome = findViewById(R.id.welcome);
        Intent intent = getIntent();
        if(intent.getExtras()!=null){
            String passedEmail = intent.getStringExtra("data");
            welcome.setText("Welcome "+passedEmail);
            Log.d("passedEmail", "patate");
        }
    }
}