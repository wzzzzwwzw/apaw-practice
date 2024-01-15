package es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.entities.PassengerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("passengerTRepository")
public interface PassengerRepository extends MongoRepository<PassengerEntity,String> {
}
