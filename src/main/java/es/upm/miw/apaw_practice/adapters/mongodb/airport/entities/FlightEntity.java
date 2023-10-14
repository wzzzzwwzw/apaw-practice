package es.upm.miw.apaw_practice.adapters.mongodb.airport.entities;

import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities.DriverEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.airport.AirLine;
import es.upm.miw.apaw_practice.domain.models.airport.Flight;
import es.upm.miw.apaw_practice.domain.models.airport.Passenger;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Document
public class FlightEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private Integer numberOfFlight;
    private LocalDate dateOfFlight;
    private List<PassengerEntity> passengers;
    private AirLineEntity airLine;

    public FlightEntity() {
        //empty for framework
    }
    public FlightEntity(Integer numberOfFlight, LocalDate dateOfFlight, List<PassengerEntity> passengers, AirLineEntity airLine) {
        this.numberOfFlight = numberOfFlight;
        this.dateOfFlight = dateOfFlight;
        this.passengers = passengers;
        this.airLine = airLine;
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

    public List<PassengerEntity> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerEntity> passengers) {
        this.passengers = passengers;
    }

    public AirLineEntity getAirLine() {
        return airLine;
    }

    public void setAirLine(AirLineEntity airLine) {
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


    public Flight toFlight(){
        List<Passenger> passengersTransform = passengers.stream()
                .map(pass -> {
                    Passenger passenger = pass.toPassenger();
                    return passenger;
                })
                .collect(Collectors.toList());
        return new Flight(numberOfFlight,dateOfFlight,passengersTransform,airLine.toAirLine());
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
