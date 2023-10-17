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
import java.util.stream.Stream;

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

    @Override
    public Stream<String> findAirlineNameByPassengerAgeGreaterThan(Integer age) {
         return this.flightRepository.findAll().stream()
                .filter(flight -> flight.getPassengers().stream()
                 .anyMatch(passengerEntity -> passengerEntity.getAge()>age))
                 .map(flightEntity -> flightEntity.getAirLine().getName()).distinct();
     }

    @Override
    public Double findAverageAgeByModel(String model) {
        Integer ageAdd = this.flightRepository.findAll().stream()
                .filter(flight -> flight.getAirLine().getAircrafts().stream()
                        .anyMatch(aircraft -> aircraft.getModel().equals(model)))
                .flatMap(flightEntity -> flightEntity.getPassengers().stream())
                .map(PassengerEntity::getAge)
                .reduce(Integer::sum).orElse(0);
        return ageAdd.doubleValue()/this.flightRepository.findAll().stream()
                .filter(flight -> flight.getAirLine().getAircrafts().stream()
                        .anyMatch(aircraft -> aircraft.getModel().equals(model)))
                .flatMap(flightEntity -> flightEntity.getPassengers().stream())
                .toList().size();
    }
}
