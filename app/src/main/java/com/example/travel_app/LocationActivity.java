package com.example.travel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        TextView typeTextView = findViewById(R.id.typeTextView);
        TextView nameTextView = findViewById(R.id.nameTextView);

        // Retrieve data from the intent
        String type = getIntent().getStringExtra("Type");
        String name = getIntent().getStringExtra("Name");

        // Set the data to the TextViews
        typeTextView.setText("Type: " + type);
        nameTextView.setText("Name: " + name);
    }
}