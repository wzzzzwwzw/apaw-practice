package es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.entities;

import es.upm.miw.apaw_practice.domain.models.ticket_bus.Ticket;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Document
public class TicketEntity {
    @Id
    private String id;
    @Indexed(unique = true)

    private String reference;
    private String departure;
    private String arrive;
    private LocalDateTime registrationDate;
    private BigDecimal price;
    @DBRef
    private PassengerEntity passengerEntity;
    @DBRef
    private TripEntity trip;

    public TicketEntity() {
        //open for framework
    }

    public TicketEntity(String reference, String departure, String arrive, LocalDateTime registrationDate, BigDecimal price, PassengerEntity passengerEntity) {
        this.id = UUID.randomUUID().toString();
        this.reference = reference;
        this.departure = departure;
        this.arrive = arrive;
        this.registrationDate = registrationDate;
        this.price = price;
        this.passengerEntity = passengerEntity;
    }

    public TicketEntity(Ticket ticket) {
        this.id = UUID.randomUUID().toString();
        BeanUtils.copyProperties(ticket, this);

    }

    public TicketEntity(String reference, String departure, String arrive, LocalDateTime registrationDate, BigDecimal price) {
        this.id = UUID.randomUUID().toString();
        this.reference = reference;
        this.departure = departure;
        this.arrive = arrive;
        this.registrationDate = registrationDate;
        this.price = price;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrive() {
        return arrive;
    }

    public void setArrive(String arrive) {
        this.arrive = arrive;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PassengerEntity getPassengerEntity() {
        return passengerEntity;
    }

    public void setPassengerEntity(PassengerEntity passengerEntity) {
        this.passengerEntity = passengerEntity;
    }

    public TripEntity getTrip() {
        return trip;
    }

    public void setTrip(TripEntity trip) {
        this.trip = trip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TicketEntity that)) return false;
        return Objects.equals(reference, that.reference) &&
                Objects.equals(departure, that.departure) &&
                Objects.equals(arrive, that.arrive) &&
                Objects.equals(registrationDate, that.registrationDate) &&
                Objects.equals(price, that.price) && Objects.equals(passengerEntity, that.passengerEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference, departure, arrive, registrationDate, price, passengerEntity);
    }

    @Override
    public String toString() {
        return "TicketEntity{" +
                "id='" + id + '\'' +
                ", reference='" + reference + '\'' +
                ", departure='" + departure + '\'' +
                ", arrive='" + arrive + '\'' +
                ", registrationDate=" + registrationDate +
                ", price=" + price +
                ", passengerEntity=" + passengerEntity +
                ", trip=" + trip +
                '}';
    }
}
