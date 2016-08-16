package maikotrindade.com.br.unitinstrumentationtests;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import maikotrindade.com.br.unitinstrumentationtests.api.GitHubUserService;
import maikotrindade.com.br.unitinstrumentationtests.model.entity.User;
import maikotrindade.com.br.unitinstrumentationtests.ui.MainActivity;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.test.MoreAsserts.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Created by joao on 8/12/16.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class DownloadUsersTest {

    private Retrofit.Builder retrofitBuilder;
    private GitHubUserService service;

    private Interceptor alwaysReturnAUserInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            String url = request.url().encodedPath();

            User user = new User();
            user.setName(url);

            String json = new Gson().toJson(user);

            Response response = new Response.Builder()
                    .body(ResponseBody.create(MediaType.parse("text/json"), json)).build();

            return response;
        }
    };

    private Interceptor alwaysReturnInvalidInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            String url = request.url().encodedPath();

            class GitHubMessage {
                public String message;
                public String documentation_url;
            }

            GitHubMessage gitHubMessage = new GitHubMessage();
            gitHubMessage.message = "Not Found";
            gitHubMessage.documentation_url = "https://developer.github.com/v3";

            String json = new Gson().toJson(gitHubMessage);

            Response response = new Response.Builder()
                    .body(ResponseBody.create(MediaType.parse("text/json"), json)).build();

            return response;
        }
    };


    private class RecyclerViewItemCountAssertion implements ViewAssertion {
        private final int expectedCount;

        public RecyclerViewItemCountAssertion(int expectedCount) {
            this.expectedCount = expectedCount;
        }

        @Override
        public void check(View view, NoMatchingViewException noViewFoundException) {
            if (noViewFoundException != null) {
                throw noViewFoundException;
            }

            RecyclerView recyclerView = (RecyclerView) view;
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            assert(adapter.getItemCount() == expectedCount);
        }
    }


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void setUp(){
        retrofitBuilder = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create());

    }

    @Test
    public void testValidUser() throws Exception {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(alwaysReturnAUserInterceptor)
                .build();

        retrofitBuilder.client(client);
        Retrofit retrofit = retrofitBuilder.build();
        service = retrofit.create(GitHubUserService.class);

        onView(withId(R.id.start_button))
                .perform(click());

        onView(withId(R.id.list))
                .check(new RecyclerViewItemCountAssertion(0));

        onView(withId(R.id.search_text))
                .check(matches(withText("")))
                .perform(typeText("username"));

        onView(withId(R.id.search_button))
                .perform(click());

        onView(withId(R.id.list))
            .check(new RecyclerViewItemCountAssertion(1));
    }

    @Test
    public void testManyUsers() throws Exception {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(alwaysReturnAUserInterceptor)
                .build();

        retrofitBuilder.client(client);
        Retrofit retrofit = retrofitBuilder.build();
        service = retrofit.create(GitHubUserService.class);

        onView(withId(R.id.start_button))
                .perform(click());

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
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(alwaysReturnInvalidInterceptor)
                .build();

        retrofitBuilder.client(client);
        Retrofit retrofit = retrofitBuilder.build();
        service = retrofit.create(GitHubUserService.class);

        onView(withId(R.id.start_button))
                .perform(click());

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
