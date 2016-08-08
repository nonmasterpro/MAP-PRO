package camt.se331.shoppingcart.config;

import camt.se331.shoppingcart.entity.*;
import camt.se331.shoppingcart.repository.PlaceRepository;
import camt.se331.shoppingcart.repository.ShoppingCartRepository;
import camt.se331.shoppingcart.repository.UserRepository;
import camt.se331.shoppingcart.service.ImageUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by Dto on 2/11/2015.
 */
@Component
@Profile("db.init")
public class DatabaseInitializationBean implements InitializingBean {
    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    UserRepository userRepository;
    @Override
    public void afterPropertiesSet() throws Exception {
        Place[] initPlace = {
                new Place(1l, "CAMT", "College of art media and technology", 10.5,112.0,"02-222-2222","Building","www.aaa.com", ImageUtil.getImage("pic/camt.jpg")),
                new Place(2l, "Male Dormitory 4th", "The unknow computer", 99.5,100.0,"02-222-2222","Dormitory","www.aaa.com", ImageUtil.getImage("pic/4thDormMale.jpg")),
                new Place(3l, "Angkeaw", " Mac book interim", 44.00, 90.00,"02-222-2222","Landmark","www.aaa.com", ImageUtil.getImage("pic/angkeaw.jpg")),
                new Place(4l, "Clock Tower", "use for lighten up the world", 10.00, 55.00 ,"02-222-2222","Landmark","www.aaa.com", ImageUtil.getImage("pic/clockTower.jpg")),
                new Place(5l, "I like ice cream", "User for what ?", 200.00, 150.00,"02-222-2222","Cafe","www.aaa.com", ImageUtil.getImage("pic/ilike.jpg")),
                new Place(6l, "Sport Field", "Call the others", 150.00, 100.00 ,"02-222-2222","Sportfield","www.aaa.com", ImageUtil.getImage("pic/sportField.jpg")),
                new Place(7l, "Salatham", "What is it?", 20.00, 260.00,"02-222-2222","Building","www.aaa.com", ImageUtil.getImage("pic/salatham.jpg")),
                new Place(8l, "RB5", "Who still use this ?", 240.00, 2.00,"02-222-2222","Building","www.aaa.com", ImageUtil.getImage("pic/rb5.jpg")),
                new Place(9l, "Faihin", "we hate it", 2.00,10.00,"02-222-2222","Restaurant","www.aaa.com", ImageUtil.getImage("pic/faihin.jpg")),
                new Place(10l, "Economic Building", "Very handsome guy use this", 30.00,200.00,"02-222-2222","Building","www.aaa.com", ImageUtil.getImage("pic/econBuilding.jpg"))
        };
        placeRepository.save(Arrays.asList(initPlace));


       /* ShoppingCart shoppingCart = new ShoppingCart();
        List<SelectedPlace> selectedProducts = new ArrayList<>();
        SelectedPlace[] initSelectedProduct = {
                new SelectedPlace(initPlace[2], 5),
                new SelectedPlace(initPlace[4], 2),
                new SelectedPlace(initPlace[1], 1),
        };
        selectedProducts.addAll(Arrays.asList(initSelectedProduct));
        Calendar calendar = new GregorianCalendar(2015, 4, 7);
        shoppingCart.setSelectedPlaces(selectedProducts);
        shoppingCart.setPurchaseDate(calendar.getTime());
        shoppingCart.setId(1L);
        shoppingCartRepository.save(shoppingCart);*/

        // add user
        Role adminRole = new Role("admin");
        Role userRole = new Role("user");
        Role userRole2 = new Role("userwholesale");


        User admin = new User();
        admin.setName("admin");
        admin.setUsername("admin");
        admin.setEmail("admin@yahoo.com");
        admin.setPassword("123456");
        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        admin.setRoles(roles);

        User user = new User();
        user.setName("chef");
        user.setUsername("chef");
        user.setEmail("user@yahoo.com");
        user.setPassword("123456");
        Set<Role> roles2 = new HashSet<>();
        roles2.add(userRole);
        user.setRoles(roles2);
/*
        User user2 = new User();
        user2.setName("waiter");
        user2.setUsername("waiter");
        user2.setEmail("user@yahoo.com");
        user2.setPassword("123456");
        Set<Role> roles3 = new HashSet<>();
        roles3.add(userRole2);
        user2.setRoles(roles3);*/


        userRepository.save(admin);
        userRepository.save(user);
//        userRepository.save(user2);
    }
}
