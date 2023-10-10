package es.upm.miw.apaw_practice.domain.models.ticket_bus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Bus {

    private String referenceBus;
    private String company;
    private String capacity;
    private LocalDateTime registrationDate;
    private Boolean accessibility;
    private Trip trip;
    private List<Passenger> passengers;


    public Bus() {
        // empty for framework
    }

    public Bus(String referenceBus, String company, String capacity, LocalDateTime registrationDate, Boolean accessibility, Trip trip, List<Passenger> passengers) {
        this.referenceBus = referenceBus;
        this.company = company;
        this.capacity = capacity;
        this.registrationDate = registrationDate;
        this.accessibility = accessibility;
        this.trip = trip;
        this.passengers = passengers;
    }

    public Bus(String referenceBus, boolean accessibility, Trip trip) {

        this.referenceBus = referenceBus;
        this.accessibility = accessibility;
        this.trip = trip;
    }


    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public String getRebus() {
        return referenceBus;
    }

    public void setRebus(String rebus) {
        this.referenceBus = rebus;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Boolean getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(Boolean accessibility) {
        this.accessibility = accessibility;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bus)) return false;
        Bus bus = (Bus) o;
        return Objects.equals(referenceBus, bus.referenceBus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(referenceBus);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "refbus='" + referenceBus + '\'' +
                ", company='" + company + '\'' +
                ", capacity='" + capacity + '\'' +
                ", registrationDate=" + registrationDate +
                ", accessibility=" + accessibility +
                ", trip=" + trip +
                ", passengers=" + passengers +
                '}';
    }
}
