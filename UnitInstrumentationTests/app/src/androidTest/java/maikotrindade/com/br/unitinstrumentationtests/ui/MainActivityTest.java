package maikotrindade.com.br.unitinstrumentationtests.ui;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import maikotrindade.com.br.unitinstrumentationtests.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by joao on 8/9/16.
 */
public class MainActivityTest {

    private String mLabelHelloWorld;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void setUp() throws Exception {
        mLabelHelloWorld = "Hello World!";
    }

    @Test
    public void testOnCreate() throws Exception {
        onView(withId(R.id.textview_hello_world)).check(matches(isDisplayed()));
        onView(withId(R.id.textview_hello_world)).check(matches(withText(mLabelHelloWorld)));
    }
}