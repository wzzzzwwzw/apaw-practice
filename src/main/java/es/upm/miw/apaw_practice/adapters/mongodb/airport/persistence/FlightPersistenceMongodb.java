package es.upm.miw.apaw_practice.adapters.mongodb.airport.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.airport.daos.FlightRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.AirLineEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.AircraftEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.FlightEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.PassengerEntity;
import es.upm.miw.apaw_practice.domain.models.airport.Flight;
import es.upm.miw.apaw_practice.domain.persistence_ports.aiport.FlightPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("flightPersistence")
public class FlightPersistenceMongodb implements FlightPersistence {

    private final FlightRepository flightRepository;
    @Autowired
    public FlightPersistenceMongodb(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight create(Flight flight) {
        List<PassengerEntity> passengerEntityList = flight.getPassengers().stream()
                .map( passenger -> {
                    PassengerEntity passengerEntity = new PassengerEntity(passenger);
                    return passengerEntity;
                }).collect(Collectors.toList());
        List<AircraftEntity> airLineAircrafts = flight.getAirLine().getAircrafts().stream()
                .map( aircraft -> {
                    AircraftEntity aircraftEntity = new AircraftEntity(aircraft);
                    return aircraftEntity;
                }).collect(Collectors.toList());
        AirLineEntity airLineEntity = new AirLineEntity(flight.getAirLine().getName(), flight.getAirLine().getDayOfFoundation(),airLineAircrafts);
        return this.flightRepository
                .save(new FlightEntity(flight.getNumberOfFlight(),flight.getDateOfFlight(),passengerEntityList,airLineEntity))
                .toFlight();
    }

    @Override
    public boolean existFlight(Integer numberOfFlight) {
        return this.flightRepository.findByNumberOfFlight(numberOfFlight)
                .isPresent();
    }
}
