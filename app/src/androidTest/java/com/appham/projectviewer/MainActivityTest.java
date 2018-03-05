package com.appham.projectviewer;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.appham.projectviewer.utils.RecyclerViewItemCountAssertion;
import com.appham.projectviewer.utils.ViewIdlingResource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void setup() {
        ViewIdlingResource progressBar = new ViewIdlingResource(mActivityRule.getActivity().findViewById(R.id.progressBar));
        IdlingRegistry.getInstance().register(progressBar);
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.appham.projectviewer", appContext.getPackageName());
    }

    @Test
    public void testLoadingBarIsNotDisplayedWhenLoaded() {
        onView(withId(R.id.listProject)).perform(
                RecyclerViewActions.scrollToPosition(0));
        onView(withId(R.id.progressBar)).check(matches(not(isDisplayed())));
    }

    @Test
    public void testClickOnFirstItemOpensProjectDetails() {
        onView(withId(R.id.listProject)).perform(
                RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.txtProjectDetails)).check(matches(isDisplayed()));
    }

    @Test
    public void testSwipeRightDeletesItem() {
        onView(withId(R.id.listProject)).perform(
                RecyclerViewActions.actionOnItemAtPosition(0, swipeRight()));
        onView(withId(R.id.listProject)).check(new RecyclerViewItemCountAssertion(1));
    }

    @Test
    public void testClickInfoShowsGooglePlayButton() {
        onView(withId(R.id.action_about)).perform(click());
        onView(withText(R.string.google_play_store)).check(matches(isDisplayed()));
    }

    @Test
    public void testClickRefreshButton() {
        onView(withId(R.id.btnRefresh)).perform(click());
        onView(withId(R.id.progressBar)).check(matches(not(isDisplayed())));
        onView(withId(R.id.listProject)).check(new RecyclerViewItemCountAssertion(2));
    }

}
