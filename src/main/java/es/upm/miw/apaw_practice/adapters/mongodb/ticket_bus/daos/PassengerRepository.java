package es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.PassengerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("PassengerTRepository")
public interface PassengerRepository extends MongoRepository<PassengerEntity,String> {
}
