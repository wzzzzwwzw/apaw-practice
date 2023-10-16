package es.upm.miw.apaw_practice.domain.services.airport;

import es.upm.miw.apaw_practice.domain.models.airport.Passenger;
import es.upm.miw.apaw_practice.domain.persistence_ports.aiport.PassengerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
    private final PassengerPersistence passengerPersistence;

    @Autowired
    public PassengerService(PassengerPersistence passengerPersistence){
        this.passengerPersistence = passengerPersistence;
    }
    public Passenger read(String name){
        return this.passengerPersistence.readByName(name);
    }
    public Passenger updateNumberOfPhone(String name, String numberOfPhone){
        Passenger passenger = this.passengerPersistence.readByName(name);
        passenger.setNumberOfPhone(numberOfPhone);
        return this.passengerPersistence.update(passenger);

    }
}
