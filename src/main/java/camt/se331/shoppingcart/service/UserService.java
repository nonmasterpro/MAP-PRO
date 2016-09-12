package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.entity.ShoppingCart;
import camt.se331.shoppingcart.entity.User;

import java.util.List;

/**
 * Created by Dto on 4/19/2015.
 */
public interface UserService {

    User findByUserName(String username);
    User login(String username, String password);
    List<User> getUsers();
    List<User> getUsersByName(String name);
    User addUser(User user);
    User deleteUser(Long id);
    User getUser(Long id);
    User updateUser(User user);
}
