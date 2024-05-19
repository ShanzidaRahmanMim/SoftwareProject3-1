package com.example.travel_app;

import android.content.Intent;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.travel_app.DetailActivity;
import com.example.travel_app.Domains.PopularDomain;
import com.example.travel_app.R;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class DetailActivityTest {

    @Rule
    public ActivityScenarioRule<DetailActivity> activityScenarioRule =
            new ActivityScenarioRule<>(new Intent(ApplicationProvider.getApplicationContext(), DetailActivity.class)
                    .putExtra("object", new PopularDomain(
                            "Srimongol,Sylhet",    // title
                            "Location",            // location
                            "A beautiful place to visit", // description
                            "King size bed",       // bed
                            true,                  // guide
                            4.8,                   // score
                            "srimongol",           // pic
                            true,                  // wifi
                            200                    // price
                    )));


    @Test
    //done
    public void testDetailActivityDisplaysCorrectly() {
        // Check if the title text view displays the correct title
        Espresso.onView(ViewMatchers.withId(R.id.detailTitleText))
                .check(ViewAssertions.matches(ViewMatchers.withText("Srimongol,Sylhet")));

        // Check if the location text view displays the correct location
        Espresso.onView(ViewMatchers.withId(R.id.locationTxt))
                .check(ViewAssertions.matches(ViewMatchers.withText("Location")));

        // Check if the description text view displays the correct description
        Espresso.onView(ViewMatchers.withId(R.id.descriptionTxt))
                .check(ViewAssertions.matches(ViewMatchers.withText("A beautiful place to visit")));

        // Check if the image view displays the correct image
        Espresso.onView(ViewMatchers.withId(R.id.imageView))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        // Check if the back button is displayed and clickable
        Espresso.onView(ViewMatchers.withId(R.id.backarrow))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .check(ViewAssertions.matches(ViewMatchers.isClickable()));
    }



    @Test
    //done
    public void testLocationTextIsCorrect() {
        // Check if the location text view displays the correct text
        Espresso.onView(ViewMatchers.withId(R.id.locationTxt))
                .check(ViewAssertions.matches(ViewMatchers.withText("Location")));
    }

    @Test
    //done
    public void testDescriptionTextIsCorrect() {
        // Check if the description text view displays the correct text
        Espresso.onView(ViewMatchers.withId(R.id.descriptionTxt))
                .check(ViewAssertions.matches(ViewMatchers.withText("A beautiful place to visit")));
    }



    @Test
    //done
    public void testTitleTextIsCorrect() {
        // Check if the title text view displays the correct text
        Espresso.onView(ViewMatchers.withId(R.id.detailTitleText))
                .check(ViewAssertions.matches(ViewMatchers.withText("Srimongol,Sylhet")));
    }

    @Test
    //done
    public void testScrollingBehavior() {
        // Perform scroll action
        Espresso.onView(ViewMatchers.withId(R.id.detailTitleText))
                .perform(ViewActions.scrollTo());

        // Check if the hotels text view is displayed after scrolling
        Espresso.onView(ViewMatchers.withId(R.id.hotels))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }


}
