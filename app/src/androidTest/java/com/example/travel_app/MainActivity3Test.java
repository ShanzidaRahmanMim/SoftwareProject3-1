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
public class MainActivity3Test {

    @Rule
    public ActivityScenarioRule<MainActivity3> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity3.class);

    @Test
    public void testRegisterWithEmptyEmail() {
        // Attempt to register with empty email
        Espresso.onView(ViewMatchers.withId(R.id.button2))
                .perform(ViewActions.click());

        // Check for error message on email field
        Espresso.onView(ViewMatchers.withId(R.id.editText2))
                .check(ViewAssertions.matches(ViewMatchers.hasErrorText("Enter an Email address")));
    }

    @Test
    public void testRegisterWithInvalidEmail() {
        // Type invalid email and a valid password
        Espresso.onView(ViewMatchers.withId(R.id.editText2))
                .perform(ViewActions.typeText("invalidemail"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.password2))
                .perform(ViewActions.typeText("password123"), ViewActions.closeSoftKeyboard());

        // Click the register button
        Espresso.onView(ViewMatchers.withId(R.id.button2))
                .perform(ViewActions.click());

        // Check for error on email field
        Espresso.onView(ViewMatchers.withId(R.id.editText2))
                .check(ViewAssertions.matches(ViewMatchers.hasErrorText("Enter a valid email address")));
    }

    @Test
    public void testRegisterWithEmptyPassword() {
        // Type valid email and leave password empty
        Espresso.onView(ViewMatchers.withId(R.id.editText2))
                .perform(ViewActions.typeText("email@example.com"), ViewActions.closeSoftKeyboard());

        // Click the register button
        Espresso.onView(ViewMatchers.withId(R.id.button2))
                .perform(ViewActions.click());

        // Check for error message on password field
        Espresso.onView(ViewMatchers.withId(R.id.password2))
                .check(ViewAssertions.matches(ViewMatchers.hasErrorText("Enter a Password")));
    }

    @Test
    public void testRegisterWithShortPassword() {
        // Type valid email and short password
        Espresso.onView(ViewMatchers.withId(R.id.editText2))
                .perform(ViewActions.typeText("email@example.com"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.password2))
                .perform(ViewActions.typeText("123"), ViewActions.closeSoftKeyboard());

        // Click the register button
        Espresso.onView(ViewMatchers.withId(R.id.button2))
                .perform(ViewActions.click());

        // Check for error message on password field
        Espresso.onView(ViewMatchers.withId(R.id.password2))
                .check(ViewAssertions.matches(ViewMatchers.hasErrorText("Minimum Length has to be 6")));
    }
}
