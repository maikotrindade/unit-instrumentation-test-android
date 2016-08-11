package maikotrindade.com.br.unitinstrumentationtests.ui;

import android.app.Application;
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
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by joao on 8/9/16.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class ApplicationTest {

    private Application mApplication;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void setUp() throws Exception {
        mApplication = mActivityRule.getActivity().getApplication();
    }

    @Test
    public void testOnCreate() throws Exception {

        assertEquals(mApplication.getApplicationInfo().targetSdkVersion, 23);
        Object[] databases = mApplication.databaseList();
        assertNotNull(databases);
        assertEquals(2, databases.length);

    }

}
