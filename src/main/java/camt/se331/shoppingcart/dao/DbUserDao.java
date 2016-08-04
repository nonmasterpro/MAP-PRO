package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.Role;
import camt.se331.shoppingcart.entity.User;
import camt.se331.shoppingcart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by love_ on 8/1/2016.
 */
@Repository
public class DbUserDao  implements UserDao{
    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersByName(String name) {
        return userRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public User addUser(User user) {
        Role customerRole = new Role("Retail Customer");
        Set<Role> roles = new HashSet<>();
        roles.add(customerRole);
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(User user) {
        userRepository.delete(user);
        user.setId(null);
        return user;
    }

    @Override
    public User updateUser (User user) {
        return userRepository.save(user);
    }
}

