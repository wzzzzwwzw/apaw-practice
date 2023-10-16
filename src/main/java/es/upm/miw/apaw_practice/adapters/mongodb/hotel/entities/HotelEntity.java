package es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities;

import es.upm.miw.apaw_practice.domain.models.hotel.Hotel;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelActivity;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelBooking;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelClient;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Arrays;

@Document
public class HotelEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private Integer stars;
    private Integer rooms;
    private List<HotelBookingEntity> bookings;
    @DBRef
    private List<HotelActivityEntity> activities;

    public HotelEntity() {
        // empty for framework
    }

    public HotelEntity(String name, Integer stars, Integer rooms, List<HotelBookingEntity> bookings, List<HotelActivityEntity> activities) {
        this.name = name;
        this.stars = stars;
        this.rooms = rooms;
        this.bookings = bookings;
        this.activities = activities;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<HotelBookingEntity> getBookings() {
        return bookings;
    }

    public void setBookings(List<HotelBookingEntity> bookings) {
        this.bookings = bookings;
    }

    public List<HotelActivityEntity> getActivities() {
        return activities;
    }

    public void setActivities(List<HotelActivityEntity> activities) {
        this.activities = activities;
    }
    
    public Hotel toObject() {
        Hotel hotel = new Hotel();
        BeanUtils.copyProperties(this, hotel);

        List<HotelActivity> activities = new ArrayList<HotelActivity>();
        this.activities.forEach(activity -> {
            activities.add(activity.toObject());
        });
        hotel.setActivities(activities);

        List<HotelBooking> bookings = new ArrayList<HotelBooking>();
        this.bookings.forEach(activity -> {
            bookings.add(activity.toObject());
        });
        hotel.setBookings(bookings);
        
        return hotel;
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
