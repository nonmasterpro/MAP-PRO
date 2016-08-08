package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.Place;
import camt.se331.shoppingcart.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dto on 2/9/2015.
 */

@Repository
public class DbPlaceDao implements PlaceDao {
    @Autowired
    PlaceRepository placeRepository;
    @Override
    public List<Place> getPlaces() {
        return placeRepository.findAll();
    }

    @Override
    public List<Place> getPlacesByName(String name) {
        return placeRepository.findByNameContainingIgnoreCase(name);
    }


    @Override
    public Place getPlace(Long id) {
        return placeRepository.findOne(id);
    }

    @Override
    public Place addPlace(Place place) {
        return placeRepository.save(place);
    }

    @Override
    public Place deletePlace(Place place) {
        placeRepository.delete(place);
        place.setId(null);
        return place;
    }

    @Override
    public Place updatePlace(Place place) {
        return placeRepository.save(place);
    }

}
