package maikotrindade.com.br.unitinstrumentationtests.model;

import org.junit.Before;
import org.junit.Test;

import maikotrindade.com.br.unitinstrumentationtests.model.entity.User;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author maiko.trindade
 * @since 11/08/2016
 */
public class UserTest {

    private User user;
    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Before
    public void setUp() {
        user = new User();
        user.setEmail("art_mar1987@email.com.uk");
        user.setName("Arthur martin");
        user.setLocation("England");
    }

    @Test
    public void testUserIsNotNull() {
        assertNotNull(user);
    }

    @Test
    public void testUserInstanceOf() throws Exception {
        assertTrue(user instanceof User);
    }

    @Test
    public void testGetEmail() throws Exception {
        assertThat(user.getEmail(), RegexMatcher.matches(EMAIL_REGEX));
        assertTrue(user.getEmail().matches(EMAIL_REGEX));
    }

    @Test
    public void getGetName() throws Exception {
        assertEquals("Arthur martin", user.getName());
    }

    @Test
    public void getGetLocation() throws Exception {
        assertEquals("England", user.getLocation());
    }

}