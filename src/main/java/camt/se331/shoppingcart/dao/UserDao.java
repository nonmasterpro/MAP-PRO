package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.User;

import java.util.List;

/**
 * Created by love_ on 8/1/2016.
 */
public interface UserDao {


    User login(String username, String password);
    User findByUserName(String username);
    List<User> getUsers();
    List<User> getUsersByName(String name);
    User addUser(User user);
    User deleteUser(User user);
    User updateUser(User user);

}
