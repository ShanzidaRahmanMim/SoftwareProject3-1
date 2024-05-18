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
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    // Test to check if the ImageView and TextViews are displayed
    @Test
    public void testUIElementsVisibility() {
        Espresso.onView(ViewMatchers.withId(R.id.imageView2)).check(matches(isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(matches(isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.textView2)).check(matches(isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.btn)).check(matches(isDisplayed()));
    }

    // Test to check the text displayed in TextViews
    @Test
    public void testTextViewContent() {
        Espresso.onView(withId(R.id.textView))
                .check(matches(withText("Let's Enjoy The Beautiful World")));
        Espresso.onView(withId(R.id.textView2))
                .check(matches(withText("Explore new places in Bangladesh and get new experiences")));
    }

    // Test to check the button click
    @Test
    public void testButtonClick() {
        Espresso.onView(withId(R.id.btn)).perform(ViewActions.click());
    }
}
