package es.upm.miw.apaw_practice.domain.models.ticket_bus;

import java.time.LocalDateTime;
import java.util.Objects;

public class Trip {
    private String path;
    private String departure;
    private String arrive;
    private LocalDateTime registrationDate;
    private String numStops;
    private Bus bus;

    public Trip() {
    }

    public Trip(String path, String departure, String arrive, LocalDateTime registrationDate, String numStops, Bus bus) {
        this.path = path;
        this.departure = departure;
        this.arrive = arrive;
        this.registrationDate = registrationDate;
        this.numStops = numStops;
        this.bus = bus;
    }
    public Trip(String path) {
        this.path = path;
    }

    public Trip(String path, String departure) {
        this.path = path;
        this.departure = departure;
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

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trip trip)) return false;
        return Objects.equals(path, trip.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "path='" + path + '\'' +
                ", departure='" + departure + '\'' +
                ", arrive='" + arrive + '\'' +
                ", registrationDate=" + registrationDate +
                ", numStops='" + numStops + '\'' +
                ", bus=" + bus +
                '}';
    }
}
