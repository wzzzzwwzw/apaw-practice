package es.upm.miw.apaw_practice.domain.models.hotel;

import java.util.List;

public class Hotel {
    private String name;
    private Integer stars;
    private Integer rooms;
    private List<HotelBooking> bookings;
    private List<HotelActivity> activities;

    public Hotel(String name, Integer stars, Integer rooms, List<HotelBooking> bookings, List<HotelActivity> activities) {
        this.name = name;
        this.stars = stars;
        this.rooms = rooms;
        this.bookings = bookings;
        this.activities = activities;
    }

    public Hotel() {
        // empty for framework
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
