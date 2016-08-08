package camt.se331.shoppingcart.entity;

import javax.persistence.*;

/**
 * Created by Dto on 2/7/2015.
 */
@Entity
public class SelectedPlace {
    @Id
    @GeneratedValue
    Long id;
    @OneToOne
    Place place;
    Integer amount;

    public Double getTotalPrice(){
        return 0.0;
    }

    public SelectedPlace() {

    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SelectedPlace that = (SelectedPlace) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (place != null ? !place.equals(that.place) : that.place != null) return false;
        return !(amount != null ? !amount.equals(that.amount) : that.amount != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SelectedPlace(Place place, Integer amount) {

        this.place = place;
        this.amount = amount;

    }
}
