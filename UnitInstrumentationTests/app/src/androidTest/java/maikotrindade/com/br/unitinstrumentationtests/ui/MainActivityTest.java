package maikotrindade.com.br.unitinstrumentationtests.ui;

import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import maikotrindade.com.br.unitinstrumentationtests.R;
import maikotrindade.com.br.unitinstrumentationtests.ui.fragment.AboutFragment;
import maikotrindade.com.br.unitinstrumentationtests.ui.fragment.FrontFragment;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by joao on 8/9/16.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class MainActivityTest {

    private String mAppTitle;
    private String mFragmentTitle;
    private String mAboutText;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void setUp() throws Exception {
        mAppTitle  = mActivityRule.getActivity()
                .getResources().getString(R.string.fragment_front_title);
        mFragmentTitle  = mActivityRule.getActivity()
                .getResources().getString(R.string.label_hello_world);
        mAboutText  = mActivityRule.getActivity()
                .getResources().getString(R.string.about_text);
    }

    @Test
    public void testOnCreate() throws Exception {
        assertEquals(mActivityRule.getActivity().getTitle(), mAppTitle);

        // The fragment FrontFragment is instantiated
        onView(withId(R.id.body_fragment))
                .check(matches(withChild(withId(R.id.fragment_front_container))));


        // The content of the fragment FrontFragment is being displayed
        onView(withId(R.id.title))
                .check(matches(isDisplayed()))
                .check(matches(withText(mFragmentTitle)));

    }

    @Test
    public void testChangeFragment() throws Exception {

        // Assert that the current fragment is FrontFragment
        onView(withId(R.id.body_fragment))
                .check(matches(withChild(withId(R.id.fragment_front_container))));

        onView(withId(R.id.title))
                .check(matches(isDisplayed()))
                .check(matches(withText(mFragmentTitle)));

        mActivityRule.getActivity().changeFragment(new AboutFragment());

        // Assert that the current fragment is AboutFragment
        onView(withId(R.id.body_fragment))
                .check(matches(withChild(withId(R.id.fragment_about_container))));

        onView(withId(R.id.about_text))
                .check(matches(isDisplayed()))
                .check(matches(withText(mAboutText)));

        mActivityRule.getActivity().changeFragment(new FrontFragment());

        // Assert that the current fragment is FrontFragment
        onView(withId(R.id.body_fragment))
                .check(matches(withChild(withId(R.id.fragment_front_container))));

        onView(withId(R.id.title))
                .check(matches(isDisplayed()))
                .check(matches(withText(mFragmentTitle)));

    }

}
