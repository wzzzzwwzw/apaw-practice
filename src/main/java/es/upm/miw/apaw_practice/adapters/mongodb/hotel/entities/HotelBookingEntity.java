package es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities;

import es.upm.miw.apaw_practice.domain.models.hotel.HotelBooking;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelClient;
import es.upm.miw.apaw_practice.domain.models.shop.Article;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
@Document
public class HotelBookingEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private Integer number;
    private Integer roomNumber;
    private LocalDate date;
    private BigDecimal cost;
    @DBRef
    private HotelClientEntity client;

    public HotelBookingEntity() {
        // empty for framework
    }

    public HotelBookingEntity(Integer number, Integer roomNumber, LocalDate date, BigDecimal cost, HotelClientEntity client) {
        this.number = number;
        this.roomNumber = roomNumber;
        this.date = date;
        this.cost = cost;
        this.client = client;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public HotelClientEntity getClient() {
        return this.client;
    }

    public void setClient(HotelClientEntity client) {
        this.client = client;
    }

    public HotelBooking toHotelBooking() {
        HotelBooking booking = new HotelBooking();
        BeanUtils.copyProperties(this, booking);
        return booking;
    }


    @Override
    public String toString() {
        return "HotelBooking {" + "\n" +
                "   number = " + number + "\n" +
                "   date = " + date + "\n" +
                "   cost = " + cost + "\n" +
                "   client = " + client + "\n" +
                '}';
    }
}
