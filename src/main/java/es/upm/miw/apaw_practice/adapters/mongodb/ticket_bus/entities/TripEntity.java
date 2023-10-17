package es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.entities;

import es.upm.miw.apaw_practice.domain.models.ticket_bus.Trip;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class TripEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String path;
    private String departure;
    private String arrive;
    private LocalDateTime registrationDate;
    private String numStops;

    private List<TicketEntity> tickets;

    public TripEntity() {
        //open for framework
    }

    public TripEntity(String path, String departure, List<TicketEntity> tickets) {
        this.id = UUID.randomUUID().toString();
        this.path = path;
        this.departure = departure;
        this.tickets = tickets;
    }

    public TripEntity(String path, String departure) {
        this.id = UUID.randomUUID().toString();
        this.path = path;
        this.departure = departure;
    }
    public TripEntity(Trip trip) {
        this.id = UUID.randomUUID().toString();
        this.registrationDate = LocalDateTime.now();
        this.numStops = numStops;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public String getNumStops() {
        return numStops;
    }

    public void setNumStops(String numStops) {
        this.numStops = numStops;
    }

    public List<TicketEntity> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketEntity> tickets) {
        this.tickets = tickets;
    }

    public Trip toTrip() {
        Trip trip = new Trip();
        BeanUtils.copyProperties(this, trip);
        return trip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TripEntity that)) return false;
        return Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash( path);
    }

    @Override
    public String toString() {
        return "TripEntity{" +
                "id='" + id + '\'' +
                ", path='" + path + '\'' +
                ", departure='" + departure + '\'' +
                ", arrive='" + arrive + '\'' +
                ", registrationDate=" + registrationDate +
                ", numStops='" + numStops + '\'' +
                ", tickets=" + tickets +
                '}';
    }


}
