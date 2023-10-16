package es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.entities;
import es.upm.miw.apaw_practice.domain.models.ticket_bus.Bus;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class BusEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String referenceBus;
    private String company;
    private String capacity;
    private LocalDateTime registrationDate;
    private Boolean accessibility;
    @DBRef
    private TripEntity trip;
    @DBRef
    private List<PassengerEntity> passengers;
    public BusEntity() {
        //open for framework
    }

    public BusEntity(String referenceBus, Boolean accessibility, TripEntity tripEntity, List<PassengerEntity> passengersEntities) {
        this.id = UUID.randomUUID().toString();
        this.referenceBus = referenceBus;
        this.accessibility = accessibility;
        this.trip = tripEntity;
        this.passengers = passengersEntities;
    }

    public BusEntity(String referenceBus, boolean accessibility, TripEntity trip) {

        this.referenceBus = referenceBus;
        this.accessibility = accessibility;
        this.trip = trip;
    }

    public BusEntity(Bus bus) {
        this.id = UUID.randomUUID().toString();
        BeanUtils.copyProperties(bus, this);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReferenceBus() {
        return referenceBus;
    }

    public void setReferenceBus(String referenceBus) {
        this.referenceBus = referenceBus;
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

    public TripEntity getTrip() {
        return trip;
    }

    public void setTrip(TripEntity trip) {
        this.trip = trip;
    }

    public List<PassengerEntity> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerEntity> passengers) {
        this.passengers = passengers;
    }

    public Boolean isAccessibility() {
        return this.accessibility;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusEntity bus)) return false;
        return Objects.equals(referenceBus, bus.referenceBus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(referenceBus);
    }

    @Override
    public String toString() {
        return "BusEntity{" +
                "id='" + id + '\'' +
                ", referenceBus='" + referenceBus + '\'' +
                ", company='" + company + '\'' +
                ", capacity='" + capacity + '\'' +
                ", registrationDate=" + registrationDate +
                ", accessibility=" + accessibility +
                ", trip=" + trip +
                ", passengers=" + passengers +
                '}';
    }
}
