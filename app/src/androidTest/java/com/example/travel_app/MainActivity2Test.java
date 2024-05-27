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


/**
 * This class contains instrumented tests for the MainActivity2 class, which is responsible
 * for user login functionality. These tests use Espresso to simulate user interactions
 * and verify correct behavior of the login feature.
 *
 * @see androidx.test.espresso.Espresso
 * @see androidx.test.espresso.action.ViewActions
 * @see androidx.test.espresso.assertion.ViewAssertions
 * @see androidx.test.espresso.matcher.ViewMatchers
 * @see androidx.test.ext.junit.rules.ActivityScenarioRule
 * @see androidx.test.ext.junit.runners.AndroidJUnit4
 * @see org.junit.Rule
 * @see org.junit.Test
 * @see org.junit.runner.RunWith
 * @see MainActivity2
 *
 * @author Hafsa Tazrian
 */
@RunWith(AndroidJUnit4.class)
public class MainActivity2Test {

    /**
     * Rule to launch MainActivity2 for each test.
     */

    @Rule
    public ActivityScenarioRule<MainActivity2> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity2.class);

    /**
     * Test to verify login behavior when the email field is empty.
     */
    @Test
    public void testLoginWithEmptyEmail() {
        // Attempt to login with empty email
        Espresso.onView(ViewMatchers.withId(R.id.button1))
                .perform(ViewActions.click());

        // Check for error message on email field
        Espresso.onView(ViewMatchers.withId(R.id.editText1))
                .check(ViewAssertions.matches(ViewMatchers.hasErrorText("Please input Email")));
    }

    /**
     * Test to verify login behavior when an invalid email is entered.
     */
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

    /**
     * Test to verify login behavior when the password field is empty.
     */
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

    /**
     * Test to verify login behavior when a short password is entered.
     */
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
