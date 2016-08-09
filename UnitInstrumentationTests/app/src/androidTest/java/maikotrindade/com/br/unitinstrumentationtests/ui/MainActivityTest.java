package maikotrindade.com.br.unitinstrumentationtests.ui;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.MediumTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import maikotrindade.com.br.unitinstrumentationtests.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by joao on 8/9/16.
 */
@RunWith(AndroidJUnit4.class)
@MediumTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    private String mHelloWorld;

    @Before
    public void initValidString(){
        mHelloWorld = mActivityRule.getActivity().getApplicationContext()
                .getResources().getString(R.string.label_hello_world);
    }

    @Test
    public void testTextViewHelloWorld() {
        onView(withId(R.id.textview_hello_world)).check(matches(withText(mHelloWorld)));
    }

}

