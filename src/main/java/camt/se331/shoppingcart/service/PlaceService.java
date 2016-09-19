package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.entity.Image;
import camt.se331.shoppingcart.entity.Place;

import java.util.List;

/**
 * Created by Dto on 2/7/2015.
 */
public interface PlaceService {
    List<Place> getPlaces();
    List<Place> getPlacesByName(String name);
    Place findByName(String name);
    Place getPlace(Long id);
    Place addPlace(Place place);
    Place deletePlace(Long id);
    Place updatePlace(Place place);
    Place addImage (Place place, Image image);
    Place removeImage(Place place, Long id);
}
