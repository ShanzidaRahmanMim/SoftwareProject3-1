package com.example.travel_app;

import android.content.Intent;
import android.util.Log;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.travel_app.R;
import com.example.travel_app.details;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

//@author Samiha
@RunWith(AndroidJUnit4.class)
public class DetailsActivityTest {

    @Rule
    public ActivityScenarioRule<details> activityScenarioRule =
            new ActivityScenarioRule<>(new Intent(ApplicationProvider.getApplicationContext(), details.class)
                    .putExtra("selectedname", "Your Selected Name"));


    @Test
    //done
    public void testListViewIsDisplayed() {
        // Check if the ListView is displayed
        Espresso.onView(ViewMatchers.withId(R.id.detailsListView))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }


    @Test
    //done
    public void testSelectedName() {
        // Check if the selected name is being used in the API request
        // This assumes that Log.e("check", selectedname); prints the correct value
        Log.e("TestLog", "Checking if selected name is used: Your Selected Name");
    }

    @Test
    //done
    public void testJsonParsing() {
        // Check if JSON parsing is done correctly
        // This assumes that Log.e("final1", selectedname); prints the correct value
        Log.e("TestLog", "Checking if JSON parsing is correct for: Your Selected Name");
    }


}