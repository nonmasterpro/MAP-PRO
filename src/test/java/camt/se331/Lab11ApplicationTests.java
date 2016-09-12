package camt.se331;

import camt.se331.shoppingcart.entity.User;
import camt.se331.shoppingcart.service.UserService;
import camt.se331.shoppingcart.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Lab11Application.class)
@WebAppConfiguration
public class Lab11ApplicationTests {

    @Test
    public void testLogin() {
        UserServiceImpl userDao = mock(UserServiceImpl.class);
        User user = new User("admin", "123456");
        {
            User returnMock = new User(1l, "admin", "admin", "admin@gmail.com", "123456");
            when(userDao.login(user.getUsername(), user.getPassword())).thenReturn(returnMock);
        }
        User result = userDao.login(user.getUsername(), user.getPassword());
        assertEquals(user.getUsername(), result.getUsername());
        assertNotNull(result);
        System.out.println(result);

        System.out.println("*****************");

        User user2 = new User("achef", "123456");
        when(userDao.login(user2.getUsername(), user2.getPassword())).thenReturn(null);
        User Failed = userDao.login(user2.getUsername(), user2.getPassword());
        assertNull(Failed);
        System.out.println(Failed);

        System.out.println("*****************");

        User user3 = new User("admin", "123456789");
        when(userDao.login(user2.getUsername(), user2.getPassword())).thenReturn(null);
        User Failedd = userDao.login(user2.getUsername(), user2.getPassword());
        assertNull(Failedd);
        System.out.println(Failedd);

    }

	@Test
    public void testAddUser() {
		UserServiceImpl userDao = mock(UserServiceImpl.class);
		User addU = new User("non1","non","non@gmail.com", "123456");
		{
			User returnMock = new User(3l, "non1", "non", "non@gmail.com", "123456");
			when(userDao.addUser(addU.getUsername(), addU.getPassword())).thenReturn(returnMock);
		}
		User result = userDao.login(addU.getUsername(), addU.getPassword());
		assertEquals(addU.getUsername(), result.getUsername());
		assertNotNull(result);
		System.out.println(result);
	}


    @Test
    public void contextLoads() {
    }

}
