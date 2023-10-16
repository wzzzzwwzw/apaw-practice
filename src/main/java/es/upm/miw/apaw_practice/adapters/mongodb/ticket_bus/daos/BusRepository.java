package es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.entities.BusEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.entities.TripEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface BusRepository extends MongoRepository<BusEntity,String> {
    Optional<BusEntity> findByReferenceBus(String referenceBus);

    List<BusEntity> findByTrip(TripEntity trip);
}
