package es.upm.miw.apaw_practice.domain.models.airport;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Flight {

    private Integer numberOfFlight;
    private LocalDate dateOfFlight;
    private List<Passenger> passengers;
    private AirLine airLine;

    public Flight() {
        //empty for framework
    }

    public Flight(Integer numberOfFlight, LocalDate dateOfFlight, List<Passenger> passengers, AirLine airLine) {
        this.numberOfFlight = numberOfFlight;
        this.dateOfFlight = dateOfFlight;
        this.passengers = passengers;
        this.airLine = airLine;
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
    public String toString() {
        return "Flight{" +
                "numberOfFlight=" + numberOfFlight +
                ", dateOfFlight=" + dateOfFlight +
                ", passengers=" + passengers +
                ", airLine=" + airLine +
                '}';
    }
}
