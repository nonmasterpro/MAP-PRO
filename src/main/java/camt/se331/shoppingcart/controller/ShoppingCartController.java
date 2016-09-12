package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.entity.Place;
import camt.se331.shoppingcart.entity.ShoppingCart;
import camt.se331.shoppingcart.entity.User;
import camt.se331.shoppingcart.service.PlaceService;
import camt.se331.shoppingcart.service.ShoppingCartService;
import camt.se331.shoppingcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dto on 4/6/2015.
 */
@RestController
@RequestMapping("/shoppingcart")
@CrossOrigin
@Scope("session")
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService;
    @Autowired
    PlaceService placeService;
    @Autowired
    UserService userService;



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ShoppingCart getShoppingCart(@PathVariable("id") Long id) {
        return shoppingCartService.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ShoppingCart updateShoppingCart(@PathVariable("id") Long id, @RequestBody ShoppingCart cart, BindingResult bindingResult) {
        return shoppingCartService.addShoppingCart(cart);
    }

    @RequestMapping(value = "/addToCart/{id}", method = RequestMethod.POST)
    public ShoppingCart addProduct(@PathVariable("id") Long id,@RequestBody ShoppingCart shoppingCart, BindingResult bindingResult, Model model, HttpServletRequest httpServletRequest) {

        Place place = placeService.getPlace(id);
        return shoppingCartService.addSelectedProduct(shoppingCart, place);
    }

//    @RequestMapping(value="/saveCart",method= RequestMethod.POST)
//    public ShoppingCart saveCart(@RequestBody ShoppingCart shoppingCart){
//        User user = userService.findByUserName(shoppingCart.getUser().getUsername());
//        shoppingCart.setUser(user);
//        return shoppingCartService.addShoppingCart(shoppingCart);
//    }
}
