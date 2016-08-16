package maikotrindade.com.br.unitinstrumentationtests;

import android.database.sqlite.SQLiteDatabase;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.Fragment;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import maikotrindade.com.br.unitinstrumentationtests.model.version.DatabaseHelper;
import maikotrindade.com.br.unitinstrumentationtests.presenter.ListFragmentPresenter;
import maikotrindade.com.br.unitinstrumentationtests.ui.MainActivity;
import maikotrindade.com.br.unitinstrumentationtests.ui.fragment.ListFragment;
import maikotrindade.com.br.unitinstrumentationtests.utils.ApiUtils;
import maikotrindade.com.br.unitinstrumentationtests.utils.RecyclerViewItemCountAssertion;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by joao on 8/12/16.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class DownloadUsersTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void prepareDatabase(){
        DatabaseHelper databaseHelper = new DatabaseHelper(mActivityRule.getActivity());
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        databaseHelper.cleanDatabase(database);
    }

    @Test
    public void testValidUser() throws Exception {
        onView(withId(R.id.start_button))
                .perform(click());

        Fragment f = mActivityRule.getActivity().getSupportFragmentManager().findFragmentById(R.id.body_fragment);
        ((ListFragment)f).setmPresenter(new ListFragmentPresenter(ApiUtils.getGitHubUserAlwaysValidService()));

        onView(withId(R.id.list))
                .check(new RecyclerViewItemCountAssertion(0));

        onView(withId(R.id.search_text))
                .check(matches(withText("")))
                .perform(typeText("username"));

//        onView(withId(R.id.search_button))
  //              .perform(click());

        onView(withId(R.id.list))
            .check(new RecyclerViewItemCountAssertion(1));
    }

    @Test
    public void testManyUsers() throws Exception {
        onView(withId(R.id.start_button))
                .perform(click());

        Fragment f = mActivityRule.getActivity().getSupportFragmentManager().findFragmentById(R.id.body_fragment);
        ((ListFragment)f).setmPresenter(new ListFragmentPresenter(ApiUtils.getGitHubUserAlwaysValidService()));

        onView(withId(R.id.list))
                .check(new RecyclerViewItemCountAssertion(0));

        for(int i=1; i<20; i++) {

            onView(withId(R.id.search_text))
                    .check(matches(withText("")))
                    .perform(typeText("username "+i));

            onView(withId(R.id.search_button))
                    .perform(click());

            onView(withId(R.id.list))
                    .check(new RecyclerViewItemCountAssertion(i));
        }

    }

    @Test
    public void testInvalidUser() throws Exception {
        onView(withId(R.id.start_button))
                .perform(click());

        Fragment f = mActivityRule.getActivity().getSupportFragmentManager().findFragmentById(R.id.body_fragment);
        ((ListFragment)f).setmPresenter(new ListFragmentPresenter(ApiUtils.getGitHubUserAlwaysInvalidService()));

        onView(withId(R.id.list))
                .check(new RecyclerViewItemCountAssertion(0));

        onView(withId(R.id.search_text))
                .check(matches(withText("")))
                .perform(typeText("username"));

        onView(withId(R.id.search_button))
                .perform(click());

        onView(withId(R.id.list))
                .check(new RecyclerViewItemCountAssertion(0));
    }

}
