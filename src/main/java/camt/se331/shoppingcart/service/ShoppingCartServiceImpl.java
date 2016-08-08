package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.dao.ShoppingCartDao;
import camt.se331.shoppingcart.entity.Place;
import camt.se331.shoppingcart.entity.SelectedPlace;
import camt.se331.shoppingcart.entity.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by Dto on 4/6/2015.
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    ShoppingCartDao shoppingCartDao;

    @Override
    @Transactional
    public ShoppingCart findById(Long id) {
        return shoppingCartDao.findById(id);
    }

    @Override
    public List<ShoppingCart> getShoppingCarts() {
        return null;
    }

    @Override
    public List<ShoppingCart> getShoppingCartBetween(Date stateDate, Date stopDate) {
        return null;
    }

    @Override
    public ShoppingCart addShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartDao.addShoppingCart(shoppingCart);
    }

    @Override
    public ShoppingCart deleteShoppingCart(ShoppingCart shoppingCart) {
       return null;
    }

    @Override
    public ShoppingCart addSelectedProduct(ShoppingCart shoppingCart, Place place) {
        // Check whether the place is in the shopping cart or not
        // if there are some, increase the amount of place, otherwise add a new selected place to the cart
        for(SelectedPlace selectedPlace :shoppingCart.getSelectedPlaces()){
            if (selectedPlace.getPlace().equals(place)){
                selectedPlace.setAmount(selectedPlace.getAmount()+1);
                return shoppingCart;
            }
        }
        SelectedPlace selectedPlace = new SelectedPlace(place,1);
        shoppingCart.getSelectedPlaces().add(selectedPlace);
        return shoppingCart;
    }
}
