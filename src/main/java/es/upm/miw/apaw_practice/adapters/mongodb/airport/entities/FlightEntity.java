package es.upm.miw.apaw_practice.adapters.mongodb.airport.entities;

import es.upm.miw.apaw_practice.domain.models.airport.AirLine;
import es.upm.miw.apaw_practice.domain.models.airport.Passenger;
import es.upm.miw.apaw_practice.domain.models.airport.Flight;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Document
public class FlightEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private Integer numberOfFlight;
    private LocalDate dateOfFlight;
    private List<Passenger> passengers;
    private AirLine airLine;

    public FlightEntity() {
        //empty for framework
    }
    public FlightEntity(Flight flight) {
        BeanUtils.copyProperties(flight, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumberOfFlight() {
        return numberOfFlight;
    }

    public void setNumberOfFlight(Integer numberOfFlight) {
        this.numberOfFlight = numberOfFlight;
    }

    public LocalDate getDateOfFlight() {
        return dateOfFlight;
    }

    public void setDateOfFlight(LocalDate dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public AirLine getAirLine() {
        return airLine;
    }

    public void setAirLine(AirLine airLine) {
        this.airLine = airLine;
    }

    @Override
    public int hashCode() {
        return this.numberOfFlight.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((FlightEntity) obj).numberOfFlight));
    }

    @Override
    public String toString() {
        return "FlightEntity{" +
                "id='" + id + '\'' +
                ", numberOfFlight=" + numberOfFlight +
                ", dateOfFlight=" + dateOfFlight +
                ", passengers=" + passengers +
                ", airLine=" + airLine +
                '}';
    }


}
