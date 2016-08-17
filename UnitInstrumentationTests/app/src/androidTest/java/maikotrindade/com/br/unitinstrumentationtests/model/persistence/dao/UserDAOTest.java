package maikotrindade.com.br.unitinstrumentationtests.model.persistence.dao;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import maikotrindade.com.br.unitinstrumentationtests.model.persistence.entity.User;

import static org.junit.Assert.*;

/**
 * Created by ricardo.sgobbe on 10/08/2016.
 */
public class UserDAOTest {

    private UserDAO mockUserDAO;
    private UserDAO userDAO;

    @Before
    public void mockingClass(){
        mockUserDAO = Mockito.mock(UserDAO.class);
        userDAO = UserDAO.getInstance();
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