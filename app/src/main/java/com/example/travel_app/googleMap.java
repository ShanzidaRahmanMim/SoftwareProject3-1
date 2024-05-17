// googleMap.java
//factory
package com.example.travel_app;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.travel_app.IMapOpeningStrategy;
import com.example.travel_app.MapOpeningStrategyFactory;
import com.example.travel_app.R;


public class googleMap extends AppCompatActivity {

    private IMapOpeningStrategy mapOpeningStrategy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);

        EditText textView = findViewById(R.id.text);
        Button button = findViewById(R.id.button);

        mapOpeningStrategy = MapOpeningStrategyFactory.createStrategy(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String source = textView.getText().toString();

                if (source.equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter source", Toast.LENGTH_SHORT).show();
                } else {
                    mapOpeningStrategy.openMap(source);
                }
            }
        });
    }
}
