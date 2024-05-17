package com.example.travel_app;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseService {
    private static FirebaseService instance;
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;

    // Private constructor for normal usage
    private FirebaseService() {
        this(FirebaseAuth.getInstance(), FirebaseDatabase.getInstance().getReference("info"));
    }

    // Package-private constructor for testing
    FirebaseService(FirebaseAuth mAuth, DatabaseReference databaseReference) {
        this.mAuth = mAuth;
        this.databaseReference = databaseReference;
    }

    public static synchronized FirebaseService getInstance() {
        if (instance == null) {
            instance = new FirebaseService();
        }
        return instance;
    }

    public FirebaseAuth getFirebaseAuth() {
        return mAuth;
    }

    public DatabaseReference getDatabaseReference() {
        return databaseReference;
    }
}
