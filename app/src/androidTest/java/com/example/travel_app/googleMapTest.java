package com.example.travel_app;

import android.content.Intent;
import android.net.Uri;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;

import org.junit.Rule;
import org.junit.Test;

public class googleMapTest {

    @Rule
    public IntentsTestRule<com.example.travel_app.googleMap> intentsTestRule =
            new IntentsTestRule<>(com.example.travel_app.googleMap.class);

    @Test
    public void testInputField_EmptyInputShowsToast() {
        // Try to click the button without entering location
        Espresso.onView(ViewMatchers.withId(R.id.button))
                .perform(ViewActions.click());

        // Verify that no intents were started
        Intents.assertNoUnverifiedIntents();
    }

    @Test
    public void testInputField_ValidInput() {
        // Type a valid location and close the keyboard
        Espresso.onView(ViewMatchers.withId(R.id.text))
                .perform(ViewActions.typeText("Central Park"), ViewActions.closeSoftKeyboard());

        // Click the navigation button
        Espresso.onView(ViewMatchers.withId(R.id.button))
                .perform(ViewActions.click());

        // Verify the intent to open a map is correct
        Intents.intended(IntentMatchers.hasAction(Intent.ACTION_VIEW));
        Intents.intended(IntentMatchers.hasData(Uri.parse("https://www.google.com/maps/dir/Central Park")));
    }
}
