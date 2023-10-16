package es.upm.miw.apaw_practice.adapters.mongodb.airport.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.airport.daos.PassengerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.PassengerEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.airport.Passenger;
import es.upm.miw.apaw_practice.domain.persistence_ports.aiport.PassengerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("passengerPersistence")
public class PassengerPersistenceMongodb implements PassengerPersistence {

    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerPersistenceMongodb(PassengerRepository passengerRepository){
        this.passengerRepository = passengerRepository;
    }

    @Override
    public Passenger readByName(String name) {
        return this.passengerRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException(" Passenger name: " + name))
                .toPassenger();
    }

    @Override
    public Passenger update(Passenger passenger) {
        PassengerEntity passengerEntity = this.passengerRepository
                .findByName(passenger.getName())
                .orElseThrow(() -> new NotFoundException("Passenger with name: " + passenger.getName()));
        passengerEntity.fromPassenger(passenger);
        return this.passengerRepository
                .save(passengerEntity)
                .toPassenger();
    }
}
