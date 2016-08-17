package maikotrindade.com.br.unitinstrumentationtests.model.dao;

import android.database.sqlite.SQLiteDatabase;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import maikotrindade.com.br.unitinstrumentationtests.model.entity.User;
import maikotrindade.com.br.unitinstrumentationtests.model.version.DatabaseHelper;
import maikotrindade.com.br.unitinstrumentationtests.ui.activity.MainActivity;

import static org.junit.Assert.*;

/**
 * Created by joao on 8/12/16.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class UserDAOTest {

    private SQLiteDatabase database;
    private DatabaseHelper databaseHelper;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void prepareDatabase(){
        databaseHelper = new DatabaseHelper(mActivityRule.getActivity());
        database = databaseHelper.getWritableDatabase();
        databaseHelper.cleanDatabase(database);
    }

    @Test
    public void testInsert() throws Exception {
        User user = new User();
        user.setName("User Name");

        UserDAO userDAO = new UserDAO(database);
        long rowID = userDAO.insert( user );
        assert( rowID != 0 );

    }

    @Test
    public void testFindAll() throws Exception {
        UserDAO userDAO = new UserDAO(database);

        List<User> users = userDAO.findAll();
        assertEquals(0, users.size());

        User user = new User();
        user.setName("User Name");

        long rowID = userDAO.insert( user );
        assert( rowID != 0 );

        users = userDAO.findAll();
        assertEquals(1, users.size());

    }
}
