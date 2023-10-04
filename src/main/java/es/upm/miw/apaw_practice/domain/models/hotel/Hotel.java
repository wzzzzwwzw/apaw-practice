package es.upm.miw.apaw_practice.domain.models.hotel;

import java.util.Arrays;

public class Hotel {
    private String name;
    private int stars;
    private int rooms;
    private HotelBooking[] bookings;
    private HotelClient[] clients;
    private HotelActivity[] activities;

    public Hotel(String name, int stars, int rooms, HotelBooking[] bookings, HotelClient[] clients, HotelActivity[] activities) {
        this.name = name;
        this.stars = stars;
        this.rooms = rooms;
        this.bookings = bookings;
        this.clients = clients;
        this.activities = activities;
    }

    public Hotel() {
        this.name = "hotelName";
        this.stars = 0;
        this.rooms = 0;
        this.bookings = new HotelBooking[0];
        this.clients = new HotelClient[0];
        this.activities = new HotelActivity[0];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public HotelBooking[] getBookings() {
        return bookings;
    }

    public void setBookings(HotelBooking[] bookings) {
        this.bookings = bookings;
    }

    public HotelClient[] getClients() {
        return clients;
    }

    public void setClients(HotelClient[] clients) {
        this.clients = clients;
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
                "  clients = " + Arrays.toString(clients) + '\'' +
                "  activities =  " + Arrays.toString(activities) + '\'' +
                '}';
    }
}
