package com.example.travel_app;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.action.ViewActions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class HomeActivityTest {

    @Rule
    public ActivityScenarioRule<HomeActivity> activityRule = new ActivityScenarioRule<>(HomeActivity.class);

    // Test to check if the RecyclerViews and TextViews are displayed
    @Test
    public void testUIElementsVisibility() {
        Espresso.onView(ViewMatchers.withId(R.id.view_pop)).check(matches(isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).check(matches(isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.textView3)).check(matches(isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.textView5)).check(matches(isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.textView7)).check(matches(isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.Mapbutton)).check(matches(isDisplayed()));
    }

    // Test to check the text displayed in TextViews
    @Test
    public void testTextViewContent() {
        Espresso.onView(withId(R.id.textView3))
                .check(matches(withText("Explore The Places To Travel")));
        Espresso.onView(withId(R.id.textView5))
                .check(matches(withText("Popular")));
        Espresso.onView(withId(R.id.textView7))
                .check(matches(withText("Category")));
    }

    // Test to check the button click leads to Google Maps screen
    @Test
    public void testMapButtonFunctionality() {
        Espresso.onView(withId(R.id.Mapbutton)).perform(ViewActions.click());

    }
}
