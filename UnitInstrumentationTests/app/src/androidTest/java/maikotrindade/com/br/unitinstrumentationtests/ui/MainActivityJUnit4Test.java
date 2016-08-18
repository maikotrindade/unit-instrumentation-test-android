package maikotrindade.com.br.unitinstrumentationtests.ui;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import maikotrindade.com.br.unitinstrumentationtests.R;
import maikotrindade.com.br.unitinstrumentationtests.ui.activity.MainActivity;
import maikotrindade.com.br.unitinstrumentationtests.ui.fragment.AboutFragment;
import maikotrindade.com.br.unitinstrumentationtests.ui.fragment.ListFragment;
import maikotrindade.com.br.unitinstrumentationtests.ui.fragment.ResultFragment;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertEquals;

/**
 * Created by joao on 18/9/16.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityJUnit4Test{

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    private MainActivity mMainActivity;

    private String mFragmentFrontTitle;
    private String mFragmentAboutTitle;
    private String mFragmentListTitle;
    private String mFragmentResultTitle;


    @Before
    public void prepare() throws Exception {
        mMainActivity = mActivityRule.getActivity();
        mFragmentFrontTitle = mMainActivity.getResources().getString(R.string.fragment_front_title);
        mFragmentAboutTitle = mMainActivity.getResources().getString(R.string.fragment_about_title);
        mFragmentListTitle  = mMainActivity.getResources().getString(R.string.fragment_list_title);
        mFragmentResultTitle = mMainActivity.getResources().getString(R.string.fragment_result_title);
    }

    @Test
    public void verifyFragmentAfterOnCreate() throws Exception {
        assertEquals(mFragmentFrontTitle, mMainActivity.getTitle());

        // FrontFragment is instantiated
        onView(withId(R.id.body_fragment))
                .check(matches(withChild(withId(R.id.fragment_front_container))));

    }

    @Test
    public void checkChangeFragment() throws Exception {

        // Assert that the current fragment is FrontFragment
        onView(withId(R.id.body_fragment))
                .check(matches(withChild(withId(R.id.fragment_front_container))));

        assertEquals(mFragmentFrontTitle, mMainActivity.getTitle());


        mMainActivity.changeFragment(new AboutFragment());

        // Assert that the current fragment is AboutFragment
        onView(withId(R.id.body_fragment))
                .check(matches(withChild(withId(R.id.fragment_about_container))));

        assertEquals(mFragmentAboutTitle, mMainActivity.getTitle());


        mMainActivity.changeFragment(new ListFragment());

        // Assert that the current fragment is ListFragment
        onView(withId(R.id.body_fragment))
                .check(matches(withChild(withId(R.id.fragment_list_container))));

        assertEquals(mFragmentListTitle, mMainActivity.getTitle());


        mMainActivity.changeFragment(new ResultFragment());

        // Assert that the current fragment is ResultFragment
        onView(withId(R.id.body_fragment))
                .check(matches(withChild(withId(R.id.fragment_result_container))));

        assertEquals(mFragmentResultTitle, mMainActivity.getTitle());

    }

}
