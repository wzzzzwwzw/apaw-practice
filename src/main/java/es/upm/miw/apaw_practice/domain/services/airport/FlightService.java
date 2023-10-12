package es.upm.miw.apaw_practice.domain.services.airport;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.airport.Flight;
import es.upm.miw.apaw_practice.domain.persistence_ports.aiport.FlightPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    private final FlightPersistence flightPersistence;

    @Autowired
    public FlightService(FlightPersistence flightPersistence){
        this.flightPersistence = flightPersistence;
    }
    public Flight create(Flight flight){
        this.assertFlightNotExist(flight.getNumberOfFlight());
        return this.flightPersistence.create(flight);
    }
    private void assertFlightNotExist(Integer numberOfFlight) {
        if (this.flightPersistence.existFlight(numberOfFlight)) {
            throw new ConflictException("Flight exist: " + numberOfFlight);
        }
    }
}
