package maikotrindade.com.br.unitinstrumentationtests.ui;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import maikotrindade.com.br.unitinstrumentationtests.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by joao on 8/9/16.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class MainActivityTest {

    private String mLabelHelloWorld;
    private String mAppName;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void setUp() throws Exception {

        mLabelHelloWorld = mActivityRule.getActivity()
                .getResources().getString(R.string.label_hello_world);

        mAppName  = mActivityRule.getActivity()
                .getResources().getString(R.string.app_name);
    }

    @Test
    public void testOnCreate() throws Exception {
        onView(withId(R.id.textview_hello_world)).check(matches(isDisplayed()));
        onView(withId(R.id.textview_hello_world)).check(matches(withText(mLabelHelloWorld)));
        assertEquals(mActivityRule.getActivity().getTitle(), mAppName);
    }
}
