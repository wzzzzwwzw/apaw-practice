package es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities;

import es.upm.miw.apaw_practice.domain.models.hotel.Hotel;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelActivity;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelBooking;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
public class HotelEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private Integer stars;
    private Integer rooms;
    private List<HotelBooking> bookings;
    private List<HotelActivity> activities;

    public HotelEntity() {
        // empty for framework
    }

    public HotelEntity(Hotel hotel) {
        BeanUtils.copyProperties(hotel, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Integer getRooms() { return rooms; }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public List<HotelBooking> getBookings() {
        return bookings;
    }

    public void setBookings(List<HotelBooking> bookings) {
        this.bookings = bookings;
    }

    public List<HotelActivity> getActivities() {
        return activities;
    }

    public void setActivities(List<HotelActivity> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Hotel {" + '\'' +
                "  name = '" + name + '\'' +
                "  rooms = '" + rooms + '\'' +
                "  bookings = " + bookings + '\'' +
                "  activities =  " + activities + '\'' +
                '}';
    }
}
