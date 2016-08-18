package maikotrindade.com.br.unitinstrumentationtests.ui;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;

import maikotrindade.com.br.unitinstrumentationtests.R;
import maikotrindade.com.br.unitinstrumentationtests.ui.activity.MainActivity;
import maikotrindade.com.br.unitinstrumentationtests.ui.fragment.AboutFragment;
import maikotrindade.com.br.unitinstrumentationtests.ui.fragment.ListFragment;
import maikotrindade.com.br.unitinstrumentationtests.ui.fragment.ResultFragment;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by joao on 18/9/16.
 */
public class MainActivityJUnit3Test extends ActivityInstrumentationTestCase2<MainActivity>{

    public MainActivityJUnit3Test(){
        super(MainActivity.class);
    }

    private MainActivity mMainActivity;
    private Instrumentation mInstrumentation;

    private String mFragmentFrontTitle;
    private String mFragmentAboutTitle;
    private String mFragmentListTitle;
    private String mFragmentResultTitle;


    protected void setUp() throws Exception {
        super.setUp();

        mInstrumentation = getInstrumentation();
        mMainActivity = getActivity();
        mFragmentFrontTitle = mMainActivity.getResources().getString(R.string.fragment_front_title);
        mFragmentAboutTitle = mMainActivity.getResources().getString(R.string.fragment_about_title);
        mFragmentListTitle  = mMainActivity.getResources().getString(R.string.fragment_list_title);
        mFragmentResultTitle = mMainActivity.getResources().getString(R.string.fragment_result_title);
    }

    public void testOnCreate() throws Exception {
        assertEquals(mFragmentFrontTitle, mMainActivity.getTitle());

        // FrontFragment is instantiated
        onView(withId(R.id.body_fragment))
                .check(matches(withChild(withId(R.id.fragment_front_container))));

    }

    public void testChangeFragment() throws Exception {

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
