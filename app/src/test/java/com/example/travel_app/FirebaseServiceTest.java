package com.example.travel_app;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

/**
 * Unit tests for the {@link FirebaseService} class.
 * This class uses Mockito to mock FirebaseAuth and DatabaseReference dependencies.
 * @see FirebaseService
 * @see com.google.firebase.auth.FirebaseAuth
 * @see com.google.firebase.database.DatabaseReference
 * @see org.mockito.Mock
 * @see org.mockito.MockitoAnnotations
 * @see org.junit.Before
 * @see org.junit.Test
 *
 * @author Hafsa Tazrian
 */

public class FirebaseServiceTest {

    @Mock
    private FirebaseAuth mockAuth;
    @Mock
    private DatabaseReference mockDatabaseReference;

    private FirebaseService firebaseService;

    /**
     * Sets up the test environment before each test.
     * Initializes Mockito annotations and creates a new {@link FirebaseService} instance with mocked dependencies.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        // Assuming FirebaseService can be modified to accept mocks
        firebaseService = new FirebaseService(mockAuth, mockDatabaseReference);
    }

    /**
     * Tests the {@link FirebaseService#getFirebaseAuth()} method.
     * Verifies that the FirebaseAuth instance is not null.
     */
    @Test
    public void testFirebaseAuth() {
        assertNotNull("FirebaseAuth should not be null", firebaseService.getFirebaseAuth());
    }

    /**
     * Tests the {@link FirebaseService#getDatabaseReference()} method.
     * Verifies that the DatabaseReference instance is not null.
     */
    @Test
    public void testDatabaseReference() {
        assertNotNull("DatabaseReference should not be null", firebaseService.getDatabaseReference());
    }
}
