package es.upm.miw.apaw_practice.adapters.mongodb.computer_store.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.entities.MonitorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MonitorRepository extends MongoRepository<MonitorEntity, String> {
    Optional<MonitorEntity> findBySerialNumber(String serialNumber);
}
