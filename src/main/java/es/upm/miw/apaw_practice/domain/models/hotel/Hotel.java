package es.upm.miw.apaw_practice.domain.models.hotel;

import java.util.Arrays;

public class Hotel {
    private String name;
    private Integer stars;
    private Integer rooms;
    private HotelBooking[] bookings;
    private HotelActivity[] activities;

    public Hotel(String name, Integer stars, Integer rooms, HotelBooking[] bookings, HotelActivity[] activities) {
        this.name = name;
        this.stars = stars;
        this.rooms = rooms;
        this.bookings = bookings;
        this.activities = activities;
    }

    public Hotel() {
        this.name = "hotelName";
        this.stars = 0;
        this.rooms = 0;
        this.bookings = new HotelBooking[0];
        this.activities = new HotelActivity[0];
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

    public HotelBooking[] getBookings() {
        return bookings;
    }

    public void setBookings(HotelBooking[] bookings) {
        this.bookings = bookings;
    }

    public HotelActivity[] getActivities() {
        return activities;
    }

    public void setActivities(HotelActivity[] activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Hotel{" + '\'' +
                "  name = '" + name + '\'' +
                "  rooms = '" + rooms + '\'' +
                "  bookings = " + Arrays.toString(bookings) + '\'' +
                "  activities =  " + Arrays.toString(activities) + '\'' +
                '}';
    }
}
