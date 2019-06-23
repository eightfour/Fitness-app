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
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ExerciseDescription {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void exerciseDescription() {
        ViewInteraction textInputEditText = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.username_textInputLayout),
                                0),
                        0),
                        isDisplayed()));
        textInputEditText.perform(replaceText("chummel"), closeSoftKeyboard());

        ViewInteraction textInputEditText2 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.password_textInputLayout),
                                0),
                        0),
                        isDisplayed()));
        textInputEditText2.perform(replaceText("X@tjvcwxybnCM87MRZarguaC6"), closeSoftKeyboard());

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
                allOf(withText("chummel"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.username_textInputLayout),
                                        0),
                                0),
                        isDisplayed()));
        editText.check(matches(withText("chummel")));

        ViewInteraction editText2 = onView(
                allOf(withText("X@tjvcwxybnCM87MRZarguaC6"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.password_textInputLayout),
                                        0),
                                0),
                        isDisplayed()));
        editText2.check(matches(withText("X@tjvcwxybnCM87MRZarguaC6")));

        ViewInteraction editText3 = onView(
                allOf(withText("X@tjvcwxybnCM87MRZarguaC6"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.password_textInputLayout),
                                        0),
                                0),
                        isDisplayed()));
        editText3.check(matches(withText("X@tjvcwxybnCM87MRZarguaC6")));

        pressBack();

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btn_login), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.content_frame),
                                        0),
                                4),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction textInputEditText3 = onView(
                allOf(withText("X@tjvcwxybnCM87MRZarguaC6"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.password_textInputLayout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText3.perform(click());

        ViewInteraction textInputEditText4 = onView(
                allOf(withText("X@tjvcwxybnCM87MRZarguaC6"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.password_textInputLayout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText4.perform(replaceText("X@tjvcwxybnCM87MRZarguaC"));

        ViewInteraction textInputEditText5 = onView(
                allOf(withText("X@tjvcwxybnCM87MRZarguaC"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.password_textInputLayout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText5.perform(closeSoftKeyboard());

        ViewInteraction textInputEditText6 = onView(
                allOf(withText("X@tjvcwxybnCM87MRZarguaC"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.password_textInputLayout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText6.perform(click());

        ViewInteraction editText4 = onView(
                allOf(withText("X@tjvcwxybnCM87MRZarguaC6"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.password_textInputLayout),
                                        0),
                                0),
                        isDisplayed()));
        editText4.check(matches(withText("X@tjvcwxybnCM87MRZarguaC6")));

        ViewInteraction editText5 = onView(
                allOf(withText("X@tjvcwxybnCM87MRZarguaC6"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.password_textInputLayout),
                                        0),
                                0),
                        isDisplayed()));
        editText5.check(matches(withText("X@tjvcwxybnCM87MRZarguaC6")));

        ViewInteraction textInputEditText7 = onView(
                allOf(withText("X@tjvcwxybnCM87MRZarguaC"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.password_textInputLayout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText7.perform(replaceText("X@tjvcwxybnCM87MRZ6arguaC"));

        ViewInteraction textInputEditText8 = onView(
                allOf(withText("X@tjvcwxybnCM87MRZ6arguaC"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.password_textInputLayout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText8.perform(closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btn_login), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.content_frame),
                                        0),
                                4),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.trainingPlanDetailList),
                        childAtPosition(
                                withId(R.id.content_frame),
                                0)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.btn_show_Exercise_Description),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withId(R.id.frameLayout),
                                                0)),
                                11),
                        isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.textView_Exercise_Description), withText("The bench press is an upper-body strength-training exercise that consists of pressing a weight upwards from a supine position.\n The person performing the exercise lies on their back on a bench with a weight grasped in both hands. They push the weight upwards until their arms are extended, not allowing the elbows to lock. They then lower the weight to chest level. This is one repetition (rep)."),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withId(R.id.frameLayout),
                                                0)),
                                10),
                        isDisplayed()));
        textView.check(matches(withText("The bench press is an upper-body strength-training exercise that consists of pressing a weight upwards from a supine position.  The person performing the exercise lies on their back on a bench with a weight grasped in both hands. They push the weight upwards until their arms are extended, not allowing the elbows to lock. They then lower the weight to chest level. This is one repetition (rep).")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.textView_Exercise_Description), withText("The bench press is an upper-body strength-training exercise that consists of pressing a weight upwards from a supine position.\n The person performing the exercise lies on their back on a bench with a weight grasped in both hands. They push the weight upwards until their arms are extended, not allowing the elbows to lock. They then lower the weight to chest level. This is one repetition (rep)."),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withId(R.id.frameLayout),
                                                0)),
                                10),
                        isDisplayed()));
        textView2.check(matches(withText("The bench press is an upper-body strength-training exercise that consists of pressing a weight upwards from a supine position.  The person performing the exercise lies on their back on a bench with a weight grasped in both hands. They push the weight upwards until their arms are extended, not allowing the elbows to lock. They then lower the weight to chest level. This is one repetition (rep).")));
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
