package com.example.travel_app;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;



public class FirebaseServiceTest {

    @Mock
    private FirebaseAuth mockAuth;
    @Mock
    private DatabaseReference mockDatabaseReference;

    private FirebaseService firebaseService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        // Assuming FirebaseService can be modified to accept mocks
        firebaseService = new FirebaseService(mockAuth, mockDatabaseReference);
    }

    @Test
    public void testFirebaseAuth() {
        assertNotNull("FirebaseAuth should not be null", firebaseService.getFirebaseAuth());
    }

    @Test
    public void testDatabaseReference() {
        assertNotNull("DatabaseReference should not be null", firebaseService.getDatabaseReference());
    }
}
