package es.upm.miw.apaw_practice.domain.models.hotel;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

public class HotelBooking {
    private int bookingNumber;
    private Date date;
    private BigDecimal cost;
    private HotelClient[] clients;

    public HotelBooking(int bookingNumber, Date date, BigDecimal cost, HotelClient[] clients) {
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

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
