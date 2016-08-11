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
import maikotrindade.com.br.unitinstrumentationtests.ui.fragment.ListFragment;
import maikotrindade.com.br.unitinstrumentationtests.ui.fragment.ResultFragment;

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

    private String mFragmentFrontTitle;
    private String mFragmentAboutTitle;
    private String mFragmentListTitle;
    private String mFragmentResultTitle;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void setUp() throws Exception {
        mFragmentFrontTitle  = mActivityRule.getActivity()
                .getResources().getString(R.string.fragment_front_title);
        mFragmentAboutTitle  = mActivityRule.getActivity()
                .getResources().getString(R.string.fragment_about_title);
        mFragmentListTitle  = mActivityRule.getActivity()
                .getResources().getString(R.string.fragment_list_title);
        mFragmentResultTitle  = mActivityRule.getActivity()
                .getResources().getString(R.string.fragment_result_title);
    }

    @Test
    public void testOnCreate() throws Exception {
        assertEquals(mFragmentFrontTitle, mActivityRule.getActivity().getTitle());

        // FrontFragment is instantiated
        onView(withId(R.id.body_fragment))
                .check(matches(withChild(withId(R.id.fragment_front_container))));

    }

    @Test
    public void testChangeFragment() throws Exception {

        // Assert that the current fragment is FrontFragment
        onView(withId(R.id.body_fragment))
                .check(matches(withChild(withId(R.id.fragment_front_container))));

        assertEquals(mFragmentFrontTitle, mActivityRule.getActivity().getTitle());


        mActivityRule.getActivity().changeFragment(new AboutFragment(), 0);

        // Assert that the current fragment is AboutFragment
        onView(withId(R.id.body_fragment))
                .check(matches(withChild(withId(R.id.fragment_about_container))));

        assertEquals(mFragmentAboutTitle, mActivityRule.getActivity().getTitle());


        mActivityRule.getActivity().changeFragment(new ListFragment(), 0);

        // Assert that the current fragment is ListFragment
        onView(withId(R.id.body_fragment))
                .check(matches(withChild(withId(R.id.fragment_list_container))));

        assertEquals(mFragmentListTitle, mActivityRule.getActivity().getTitle());


        mActivityRule.getActivity().changeFragment(new ResultFragment(), 0);

        // Assert that the current fragment is ResultFragment
        onView(withId(R.id.body_fragment))
                .check(matches(withChild(withId(R.id.fragment_result_container))));

        assertEquals(mFragmentResultTitle, mActivityRule.getActivity().getTitle());

    }

}
