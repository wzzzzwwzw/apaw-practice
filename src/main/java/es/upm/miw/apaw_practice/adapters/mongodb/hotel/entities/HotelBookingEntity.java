package es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities;

import es.upm.miw.apaw_practice.domain.models.hotel.HotelBooking;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelClient;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class HotelBookingEntity {
    @Id
    private String id;
    @Indexed
    private Integer bookingNumber;
    private Integer roomNumber;
    private LocalDate date;
    private BigDecimal cost;
    private HotelClient client;

    public HotelBookingEntity() {
        // empty for framework
    }

    public HotelBookingEntity(HotelBooking booking) {
        BeanUtils.copyProperties(booking, this);
        this.id = UUID.randomUUID().toString();
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
