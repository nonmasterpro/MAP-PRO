package camt.se331.shoppingcart.repository;

import camt.se331.shoppingcart.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Dto on 2/9/2015.
 */

public interface PlaceRepository extends JpaRepository<Place,Long>{
    public List<Place> findByNameLike(String name);
    public List<Place> findByNameContaining(String name);
    public List<Place> findByNameContainingIgnoreCase(String name);
    public List<Place> findByNameOrDescriptionContainingIgnoreCase(String name, String description);
}
