package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.DealershipEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DealershipRepository extends MongoRepository<DealershipEntity, String> {
}
