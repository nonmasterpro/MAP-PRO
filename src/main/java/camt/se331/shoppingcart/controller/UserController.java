package camt.se331.shoppingcart.controller;
import camt.se331.shoppingcart.entity.User;
import camt.se331.shoppingcart.service.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<JSONObject> add(@RequestBody User user, BindingResult bindingResult){
        User result = userService.addUser(user);
        if(result!=null){
            JSONObject object = new JSONObject();
            object.put("result","Add Success");
            object.put("id",result.getId());
            return ResponseEntity.ok(object);
        }else{
            JSONObject object = new JSONObject();
            object.put("result","Username or Email are already exist");
            return ResponseEntity.ok(object);
        }
    }

    @RequestMapping(value = "customer/{id}",method = RequestMethod.PUT)
    public  User edit(@PathVariable("id") Long id,@RequestBody User user, BindingResult bindingResult){
        return userService.updateUser(user);}

    @RequestMapping(value = "customer/{id}",method = RequestMethod.DELETE)
    public  User edit(@PathVariable("id") Long id){
        return userService.deleteUser(id);
    }

}
