package es.upm.miw.apaw_practice.domain.models.hotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

public class HotelBooking {
    private Integer bookingNumber;
    private LocalDate date;
    private BigDecimal cost;
    private HotelClient[] clients;

    public HotelBooking(Integer bookingNumber, LocalDate date, BigDecimal cost, HotelClient[] clients) {
        this.bookingNumber = bookingNumber;
        this.date = date;
        this.cost = cost;
        this.clients = clients;
    }

    public HotelBooking() {
        this.bookingNumber = 0;
        this.date = null;
        this.cost = BigDecimal.ZERO;
        this.clients = new HotelClient[]{new HotelClient()};
    }

    public Integer getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(Integer bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

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

    public HotelClient[] getClients() {
        return this.clients;
    }

    public void setClients(HotelClient[] clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "HotelBooking {" + '\'' +
                "  bookingNumber = " + bookingNumber + '\'' +
                "  date = " + date + '\'' +
                "  cost = " + cost + '\'' +
                "  clients = " + Arrays.toString(clients) + '\'' +
                '}';
    }
}
