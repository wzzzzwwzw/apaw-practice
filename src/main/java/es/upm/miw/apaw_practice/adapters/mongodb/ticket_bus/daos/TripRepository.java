package es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.daos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("TripTRepository")
public interface TripRepository extends MongoRepository<TripRepository,String> {
}
