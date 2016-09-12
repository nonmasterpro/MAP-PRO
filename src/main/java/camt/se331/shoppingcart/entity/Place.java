package camt.se331.shoppingcart.entity;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dto on 2/7/2015.
 */
@Entity
public class Place implements Comparable{
    @Id
    @GeneratedValue
    Long id;
    String name;
    String description;
    Double x;
    Double y;
    String contact;
    String contactNo;
    String type;
    String website;

    public Place(Long id,String name, String description, Double x, Double y, String contact, String contactNo, String type, String website, Image image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.x = x;
        this.y = y;
        this.contact = contact;
        this.contactNo = contactNo;
        this.type = type;
        this.website = website;
        this.images.add(image) ;
    }

    public Place(Long id, String name, String description, Double x, Double y, String contact, String type, String website, Image image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.x = x;
        this.y = y;
        this.contact = contact;
        this.type = type;
        this.website = website;
        this.images.add(image) ;
    }


    public Place(Long id, String name, String description, Double x, Double y, String contact, String type, Image image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.x = x;
        this.y = y;
        this.contact = contact;
        this.type = type;
        this.images.add(image) ;
    }



    public Place(Long id, String name, String description, Double x, Double y, String contact, Image image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.x = x;
        this.y = y;
        this.contact = contact;
        this.images.add(image) ;
    }

    public Place(Long id, String name, String description, Double x, Double y, Image image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.x = x;
        this.y = y;
        this.images.add(image) ;
    }
    public Place(Long id, String name, String description, Double x, Double y) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.x = x;
        this.y = y;

    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getWebsite() { return website; }

    public void setWebsite(String website) { this.website = website; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        if (!id.equals(place.id)) return false;
        if (!name.equals(place.name)) return false;
        if (!description.equals(place.description)) return false;
        if (!x.equals(place.x)) return false;
        return y.equals(place.y);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + x.hashCode();
        result = 31 * result + y.hashCode();
        return result;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Set<Image> images = new HashSet<>();

    public Place(Long id, String name, String description, Double x, Image image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.x = x;
        this.images.add(image) ;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Place(){

    };

    public Double getNetPrice(){
        return getX()*(1-VatEntity.getInstance().getVat());
    }

    public Double getTax(){
        return 0.0;
    }

    public Place(Long id, String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.x = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public int compareTo(Object o) {

        return (int) (this.getId() - ((Place)o).getId());
    }
}