package com.example.travel_app;

import android.content.Intent;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.travel_app.R;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
//@author samiha
@RunWith(AndroidJUnit4.class)
public class ReviewActivityTest {

    @Rule
    public ActivityScenarioRule<ReviewActivity> activityScenarioRule =
            new ActivityScenarioRule<>(new Intent(ApplicationProvider.getApplicationContext(), ReviewActivity.class));

    @Test
    //done
    public void testActivityIsDisplayed() {
        // Check if the ReviewActivity layout is displayed
        Espresso.onView(ViewMatchers.withId(R.id.reviewLayout))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }


    @Test
    //done
    public void testSubmitReview() {
        // Set rating and comment
        Espresso.onView(ViewMatchers.withId(R.id.ratingBar))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.commentEditText))
                .perform(ViewActions.typeText("Great experience!"), ViewActions.closeSoftKeyboard());

        // Submit the review
        Espresso.onView(ViewMatchers.withId(R.id.submitButton))
                .perform(ViewActions.click());


        Espresso.onView(ViewMatchers.withId(R.id.commentEditText))
                .check(ViewAssertions.matches(ViewMatchers.withText("Great experience!")));
    }
}
