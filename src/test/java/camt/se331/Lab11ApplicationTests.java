package camt.se331;

import camt.se331.shoppingcart.entity.Place;
import camt.se331.shoppingcart.entity.User;
import camt.se331.shoppingcart.service.PlaceServiceImpl;
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

    //User
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
        when(userDao.login(user3.getUsername(), user3.getPassword())).thenReturn(null);
        User Failed2 = userDao.login(user3.getUsername(), user3.getPassword());
        assertNull(Failed2);
        System.out.println(Failed2);

    }

	@Test
    public void testAddUser() {
		UserServiceImpl userDao = mock(UserServiceImpl.class);
		User addU = new User("non1","non","non@gmail.com", "123456");
		{
			User returnMock = new User(3l, "non1", "non", "non@gmail.com", "123456");
			when(userDao.addUser(addU)).thenReturn(returnMock);
		}
		User result = userDao.addUser(addU);
//		assertEquals(addU, result);
		assertNotNull(result);
		System.out.println(result);

        System.out.println("*****************");

        User addU2 = new User("non1","non","admin@gmail.com", "123456");
        when(userDao.addUser(addU2)).thenReturn(null);
        User failed = userDao.addUser(addU2);
        assertNull(failed);
        System.out.println(failed);

        System.out.println("*****************");

        User addU3 = new User("chef","non","sfasdf@gmail.com", "123456");
        when(userDao.addUser(addU3)).thenReturn(null);
        User failed2 = userDao.addUser(addU3);
        assertNull(failed2);
        System.out.println(failed2);


    }

    @Test
    public void testUpdateUser() {
        UserServiceImpl userDao = mock(UserServiceImpl.class);
        User upU = new User("non", "123456");
        {
            User returnMock = new User(3l, "non1", "non", "non@gmail.com", "123456");
            when(userDao.updateUser(upU)).thenReturn(returnMock);
        }
        User result = userDao.updateUser(upU);
//		assertEquals(addU, result);
        assertNotNull(result);
        System.out.println(result);




    }

    @Test
    public void testDelUser() {
        UserServiceImpl userDao = mock(UserServiceImpl.class);
        Long id = 2l;
        {
            User returnMock = new User(2l, "chef", "chef", "user@gmail.com", "123456");
            when(userDao.deleteUser(id)).thenReturn(returnMock);
        }
        User result = userDao.deleteUser(id);
//		assertEquals(addU, result);
        assertNotNull(result);
        System.out.println(result);
    }

    //Place
    @Test
    public void testAddPlace() {
        PlaceServiceImpl placeDao = mock(PlaceServiceImpl.class);
        Place addP = new Place("Camtt","non","1231","building","www.a.com",123.0,123.0);
        {
            Place returnMock = new Place(1l,"Camtt","non","1231","building","www.a.com",123.0,123.0);
            when(placeDao.addPlace(addP)).thenReturn(returnMock);
        }
        Place result = placeDao.addPlace(addP);
//		assertEquals(addU, result);
        assertNotNull(result);
        System.out.println(result);

        System.out.println("*****************");

        Place addP2 = new Place("Camt","non","1231","building","www.a.com",123.0,123.0);
        when(placeDao.addPlace(addP2)).thenReturn(null);
        Place failed = placeDao.addPlace(addP2);
        assertNull(failed);
        System.out.println(failed);



    }

    @Test
    public void testUpdatePlace() {
        PlaceServiceImpl placeDao = mock(PlaceServiceImpl.class);
        Place upP = new Place("Camtt","non","1231","building","www.a.com",123.0,123.0);
        {
            Place returnMock = new Place(1l,"Camtt","non","1231","building","www.a.com",123.0,123.0);
            when(placeDao.updatePlace(upP)).thenReturn(returnMock);
        }
        Place result = placeDao.updatePlace(upP);
//		assertEquals(addU, result);
        assertNotNull(result);
        System.out.println(result);

        System.out.println("*****************");

        Place upP2 = new Place("Camt","non","1231","building","www.a.com",123.0,123.0);
        when(placeDao.updatePlace(upP2)).thenReturn(null);
        Place failed = placeDao.updatePlace(upP2);
        assertNull(failed);
        System.out.println(failed);



    }

    @Test
    public void testDelPlace() {
        PlaceServiceImpl placeDao = mock(PlaceServiceImpl.class);
        Long id = 1l;
        {
            Place returnMock = new Place(1l,"Camtt","non","1231","building","www.a.com",123.0,123.0);
            when(placeDao.deletePlace(id)).thenReturn(returnMock);
        }
        Place result = placeDao.deletePlace(id);
//		assertEquals(addU, result);
        assertNotNull(result);
        System.out.println(result);
    }


    //
    @Test
    public void contextLoads() {
    }

}
