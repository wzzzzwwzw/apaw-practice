package es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.entities.TripEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("TripTRepository")
public interface TripRepository extends MongoRepository<TripEntity,String> {
    Optional<TripEntity> findByPath(String path);

    Optional<TripEntity> findByDeparture(String departure);
}
