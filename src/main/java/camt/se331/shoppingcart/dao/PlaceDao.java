package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.Place;

import java.util.List;

/**
 * Created by Dto on 2/7/2015.
 */
public interface PlaceDao {
    List<Place> getPlaces();
    List<Place> getPlacesByName(String name);
    Place getPlace(Long id);
    Place addPlace(Place place);
    Place deletePlace(Place place);
    Place updatePlace(Place place);


}
