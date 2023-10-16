package es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.entities.TripEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TripRepository extends MongoRepository<TripEntity,String> {
}
