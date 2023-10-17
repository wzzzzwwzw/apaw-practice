package es.upm.miw.apaw_practice.domain.services.ticket_bus;

import es.upm.miw.apaw_practice.domain.models.ticket_bus.PassengerAccessModification;
import es.upm.miw.apaw_practice.domain.persistence_ports.ticket_bus.PassengerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerBusService {

    private final PassengerPersistence passengerPersistence;

    @Autowired
    public PassengerBusService(PassengerPersistence passengerPersistence) {
        this.passengerPersistence = passengerPersistence;
    }

    public void updateAccessPassenger(PassengerAccessModification passengerAccessModification) {
        this.passengerPersistence.updateAccessPassenger(passengerAccessModification);
    }
}
