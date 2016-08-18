package maikotrindade.com.br.unitinstrumentationtests.model.persistence.dao;

import android.database.sqlite.SQLiteDatabase;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import maikotrindade.com.br.unitinstrumentationtests.model.dao.UserDAO;
import maikotrindade.com.br.unitinstrumentationtests.model.entity.User;
import maikotrindade.com.br.unitinstrumentationtests.model.version.DatabaseHelper;
import maikotrindade.com.br.unitinstrumentationtests.ui.activity.MainActivity;

import static android.support.test.espresso.action.ViewActions.click;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.junit.Assert.*;

/**
 * Created by ricardo.sgobbe on 10/08/2016.
 */
public class UserDAOTest {

    private UserDAO mockUserDAO;
    private UserDAO userDAO;
    private SQLiteDatabase database;
    private DatabaseHelper databaseHelper;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void mockingClass(){
        mockUserDAO = Mockito.mock(UserDAO.class);
        databaseHelper = new DatabaseHelper(mActivityRule.getActivity());
        database = databaseHelper.getWritableDatabase();
        databaseHelper.cleanDatabase(database);
        userDAO = new UserDAO(database);

    }

    @Test
    public void testInsert() throws Exception {
        User user = new User();
        user.setName("TestName");
        user.setLogin("test");
        user.setEmail("test@test.com");
        user.setCompany("test company");
        user.setTimeCreated("00:00:00");
        user.setTimeUpdated("06:56:00");
        Mockito.when(mockUserDAO.insert(user)).then(new Answer<Long>() {
            @Override
            public Long answer(InvocationOnMock invocation) throws Throwable {
                User user = (User) invocation.getArguments()[0];
                user.setId(3);
                return Long.valueOf(user.getId());
            }
        });
        assertEquals(3, mockUserDAO.insert(user));
    }

    @Test
    public void testFindAll() throws Exception {
        Mockito.when(mockUserDAO.findAll()).thenReturn(userDAO.findAll());
        assertNotNull(mockUserDAO.findAll());
    }

    @Test
    public void testFindUserById(){
        Mockito.when(mockUserDAO.findUserById(1)).thenReturn(userDAO.findUserById(1));
        assertNotNull(mockUserDAO.findUserById(1));
    }

}