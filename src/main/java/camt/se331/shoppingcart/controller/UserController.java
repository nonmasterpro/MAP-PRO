package camt.se331.shoppingcart.controller;
import camt.se331.shoppingcart.entity.User;
import camt.se331.shoppingcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Created by love_ on 8/1/2016.
 */
@RestController
@RequestMapping("/")
@CrossOrigin

public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "customer",method = RequestMethod.GET)
    public List<User> list(){
        return userService.getUsers();
    }

    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    public  List<User> findUserByUsername (@RequestParam("name")String name){return userService.getUsersByName(name);}

    @RequestMapping(value = "customer/{id}",method = RequestMethod.GET)
    public  User getUser(@PathVariable("id") Long id){
        return userService.getUser(id);
    }


    @RequestMapping(value = "customer", method = RequestMethod.POST)
    public @ResponseBody
    User add(@RequestBody User user, BindingResult bindingResult){
        return userService.addUser(user);
    }

}
