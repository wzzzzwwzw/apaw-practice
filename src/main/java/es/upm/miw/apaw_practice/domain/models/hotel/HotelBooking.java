package es.upm.miw.apaw_practice.domain.models.hotel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class HotelBooking {
    private Integer bookingNumber;
    private Integer roomNumber;
    private LocalDate date;
    private BigDecimal cost;
    private HotelClient client;

    public HotelBooking(Integer bookingNumber, Integer roomNumber, LocalDate date, BigDecimal cost, HotelClient client) {
        this.bookingNumber = bookingNumber;
        this.roomNumber = roomNumber;
        this.date = date;
        this.cost = cost;
        this.client = client;
    }

    public HotelBooking() {
        // empty for framework
    }

    public Integer getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(Integer bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public Integer getRoomNumber() { return roomNumber; }

    public void setRoomNumber(Integer roomNumber) { this.roomNumber = roomNumber; }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public HotelClient getClient() {
        return this.client;
    }

    public void setClient(HotelClient client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "HotelBooking {" + "\n" +
                "   bookingNumber = " + bookingNumber + "\n" +
                "   date = " + date + "\n" +
                "   cost = " + cost + "\n" +
                "   client = " + client + "\n" +
                '}';
    }
}
