package de.university.reutlingen.mobile.computing.fitnessapp;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CheckShowPasswordButton {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkShowPasswordButton() {
        ViewInteraction textInputEditText = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.username_textInputLayout),
                                0),
                        0),
                        isDisplayed()));
        textInputEditText.perform(replaceText("username"), closeSoftKeyboard());

        ViewInteraction textInputEditText2 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.password_textInputLayout),
                                0),
                        0),
                        isDisplayed()));
        textInputEditText2.perform(replaceText("password"), closeSoftKeyboard());

        ViewInteraction checkableImageButton = onView(
                allOf(withId(R.id.text_input_password_toggle), withContentDescription("Show password"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.password_textInputLayout),
                                        0),
                                1),
                        isDisplayed()));
        checkableImageButton.perform(click());

        ViewInteraction editText = onView(
                allOf(withText("password"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.password_textInputLayout),
                                        0),
                                0),
                        isDisplayed()));
        editText.check(matches(withText("password")));

        ViewInteraction editText2 = onView(
                allOf(withText("password"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.password_textInputLayout),
                                        0),
                                0),
                        isDisplayed()));
        editText2.check(matches(withText("password")));

        ViewInteraction editText3 = onView(
                allOf(withText("password"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.password_textInputLayout),
                                        0),
                                0),
                        isDisplayed()));
        editText3.check(matches(withText("password")));

        ViewInteraction editText4 = onView(
                allOf(withText("password"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.password_textInputLayout),
                                        0),
                                0),
                        isDisplayed()));
        editText4.check(matches(withText("password")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
