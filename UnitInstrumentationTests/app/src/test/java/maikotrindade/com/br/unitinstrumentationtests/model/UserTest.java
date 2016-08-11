package maikotrindade.com.br.unitinstrumentationtests.model;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import maikotrindade.com.br.unitinstrumentationtests.model.entity.User;

/**
 * @author maiko.trindade
 * @since 11/08/2016
 */
public class UserTest {

    private User user;

    @Before
    public void setUp() {
        user = new User();
    }

    @Test
    public void testUserIsNotNull() {
        Assert.assertNotNull(user);
    }

    @Test
    public void testGetLogin() throws Exception {

    }

    @Test
    public void testGetName() throws Exception {

    }
}