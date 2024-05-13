package com.example.travel_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class MainActivity3 extends AppCompatActivity {

    private Button button2;
    private EditText email2;
    private EditText password2;
    private EditText date2;
    private EditText phone2;
    private FirebaseService firebaseService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        firebaseService = FirebaseService.getInstance(); // Get singleton instance

        button2 = findViewById(R.id.button2);
        email2 = findViewById(R.id.editText2);
        password2 = findViewById(R.id.password2);
        date2 = findViewById(R.id.name2);
        phone2 = findViewById(R.id.phone2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userRegister();
                saveData();
            }
        });
    }

    private void saveData() {
        String date = date2.getText().toString().trim();
        String phone = phone2.getText().toString().trim();
        String email = email2.getText().toString().trim();

        Info info = new Info(date, phone);
        firebaseService.getDatabaseReference().child("users").child(phone).setValue(info);
        Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
    }

    private void userRegister() {
        String email = email2.getText().toString().trim();
        String password = password2.getText().toString().trim();
        if (email.isEmpty()) {
            email2.setError("Enter an Email address");
            email2.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            email2.setError("Enter a valid email address");
            email2.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            password2.setError("Enter a Password");
            password2.requestFocus();
            return;
        }
        if (password.length() < 6) {
            password2.setError("Minimum Length has to be 6");
            password2.requestFocus();
            return;
        }

        firebaseService.getFirebaseAuth().createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Register Successful", Toast.LENGTH_SHORT).show();
                    Intent intent3 = new Intent(MainActivity3.this, HomeActivity.class);
                    startActivity(intent3);
                } else {
                    Toast.makeText(getApplicationContext(), "Register Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
