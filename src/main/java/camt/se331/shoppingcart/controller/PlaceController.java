package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.entity.Place;
import camt.se331.shoppingcart.service.PlaceService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dto on 2/8/2015.
 */
@RestController
@RequestMapping("/")
@CrossOrigin
public class PlaceController {
    @Autowired
    PlaceService placeService;

    @RequestMapping(value = "place",method = RequestMethod.GET)
    public  List<Place> list(){
        return placeService.getPlaces();
    }


    @RequestMapping(value = "getPlace",method = RequestMethod.GET)
    public  List<Place> getListByName(@RequestParam("name")String name){
        return placeService.getPlacesByName(name);
    }


    @RequestMapping(value = "place",method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<JSONObject> add(@RequestBody Place place, BindingResult bindingResult){
        Place result = placeService.addPlace(place);
        if(result!=null){
            JSONObject object = new JSONObject();
            object.put("result","Add Success");
            object.put("id",result.getId());
            return ResponseEntity.ok(object);
        }else{
            JSONObject object = new JSONObject();
            object.put("result","Name already exist");
            return ResponseEntity.ok(object);
        }
    }

    @RequestMapping(value = "place/{id}",method = RequestMethod.GET)
    public Place getProduct(@PathVariable("id") Long id){
        return placeService.getPlace(id);
    }

    @RequestMapping(value = "place/{id}",method = RequestMethod.PUT)
    public Place edit(@PathVariable("id") Long id, @RequestBody Place place, BindingResult bindingResult){
        return placeService.updatePlace(place);
    }

    @RequestMapping(value = "place/remove",method = RequestMethod.DELETE)
    public Place remove(@RequestParam("id")Long id){
        return placeService.deletePlace(id);
    }
}
