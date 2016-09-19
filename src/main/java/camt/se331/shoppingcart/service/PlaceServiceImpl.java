package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.dao.PlaceDao;
import camt.se331.shoppingcart.entity.Image;
import camt.se331.shoppingcart.entity.Place;
import camt.se331.shoppingcart.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Dto on 2/8/2015.
 */
@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    PlaceDao placeDao;
    @Override
    public List<Place> getPlaces() {
        return placeDao.getPlaces();
    }

    @Override
    @Transactional
    public Place findByName(String name) {
        return placeRepository.findByname(name);
    }

    @Override
    public Place getPlace(Long id) {
        return placeDao.getPlace(id);
    }

    @Override
    public Place addPlace(Place place) {
        return placeDao.addPlace(place);
    }

    @Override
    public Place deletePlace(Long id) {
        Place place = getPlace(id);
        placeRepository.delete(id);
        return null;
    }

    @Override
    public Place updatePlace(Place place) {
        return placeDao.updatePlace(place);
    }

    @Override
    public List<Place> getPlacesByName(String name) {
        return placeDao.getPlacesByName(name);
    }

    @Override
    @Transactional
    public Place addImage(Place place, Image image) {
        image=ImageUtil.resizeImage(image,200);
        place.getImages().add(image);
        placeDao.updatePlace(place);
        return place;
    }

    @Override
    @javax.transaction.Transactional
    public Place removeImage(Place place, Long id) {
        //place.getImages().removeAll(place.getImages());
        Iterator<Image> imgitr = place.getImages().iterator();
        while (imgitr.hasNext()) {
            Image img = imgitr.next();
            //System.out.println("---- ID "+img.getId());
            if( img.getId().intValue() == id.intValue() ) {
                place.getImages().remove(img);
                //System.out.println("---- SIZE " + place.getImages().size());
            }
        }
        placeDao.updatePlace(place);
        return place;
    }


}
