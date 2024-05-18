package com.example.travel_app;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivity2Test {

    @Rule
    public ActivityScenarioRule<MainActivity2> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity2.class);

    @Test
    public void testLoginWithEmptyEmail() {
        // Attempt to login with empty email
        Espresso.onView(ViewMatchers.withId(R.id.button1))
                .perform(ViewActions.click());

        // Check for error message on email field
        Espresso.onView(ViewMatchers.withId(R.id.editText1))
                .check(ViewAssertions.matches(ViewMatchers.hasErrorText("Please input Email")));
    }

    @Test
    public void testLoginWithInvalidEmail() {
        // Type invalid email
        Espresso.onView(ViewMatchers.withId(R.id.editText1))
                .perform(ViewActions.typeText("wrongemail"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.password1))
                .perform(ViewActions.typeText("password123"), ViewActions.closeSoftKeyboard());

        // Click the login button
        Espresso.onView(ViewMatchers.withId(R.id.button1))
                .perform(ViewActions.click());

        // Check for error on email field
        Espresso.onView(ViewMatchers.withId(R.id.editText1))
                .check(ViewAssertions.matches(ViewMatchers.hasErrorText("Enter proper email address")));
    }

    @Test
    public void testLoginWithEmptyPassword() {
        // Type valid email and leave password empty
        Espresso.onView(ViewMatchers.withId(R.id.editText1))
                .perform(ViewActions.typeText("hafsa@gmail.com"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.password1))
                .perform(ViewActions.clearText());

        // Click the login button
        Espresso.onView(ViewMatchers.withId(R.id.button1))
                .perform(ViewActions.click());

        // Check for error message on password field
        Espresso.onView(ViewMatchers.withId(R.id.password1))
                .check(ViewAssertions.matches(ViewMatchers.hasErrorText("Please input password")));
    }

    @Test
    public void testLoginWithShortPassword() {
        // Type valid email and short password
        Espresso.onView(ViewMatchers.withId(R.id.editText1))
                .perform(ViewActions.typeText("hafsa@gmail.com"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.Uname))
                .perform(ViewActions.typeText("Hafsa"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.password1))
                .perform(ViewActions.typeText("123"), ViewActions.closeSoftKeyboard());

        // Click the login button
        Espresso.onView(ViewMatchers.withId(R.id.button1))
                .perform(ViewActions.click());

        // Check for error message on password field
        Espresso.onView(ViewMatchers.withId(R.id.password1))
                .check(ViewAssertions.matches(ViewMatchers.hasErrorText("Wrong Password")));
    }
}
