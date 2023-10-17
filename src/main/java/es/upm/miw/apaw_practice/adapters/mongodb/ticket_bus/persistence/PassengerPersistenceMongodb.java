package es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.daos.PassengerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.entities.PassengerEntity;
import es.upm.miw.apaw_practice.domain.models.ticket_bus.PassengerAccessModification;
import es.upm.miw.apaw_practice.domain.persistence_ports.ticket_bus.PassengerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("passengerPersistenceTicketBus")
public class PassengerPersistenceMongodb implements PassengerPersistence {
    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerPersistenceMongodb(PassengerRepository passengerRepository) {

        this.passengerRepository = passengerRepository;
    }

    @Override
    public void updateAccessPassenger(PassengerAccessModification passengerAccessModification) {
        List<PassengerEntity> passengers = this.passengerRepository.findAll().stream()
                .filter(passenger -> Optional.ofNullable(passenger.getAccessibility()).equals(passengerAccessModification.getOldAccess()))
                .collect(Collectors.toList());
        passengers.forEach(passenger -> passenger.setAccessibility(passengerAccessModification.getNewAccess()));
        this.passengerRepository.saveAll(passengers);
    }


}
