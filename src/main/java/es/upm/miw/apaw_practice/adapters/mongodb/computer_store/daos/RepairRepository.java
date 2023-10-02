package es.upm.miw.apaw_practice.adapters.mongodb.computer_store.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.entities.RepairEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RepairRepository extends MongoRepository<RepairEntity, String> {
    Optional<RepairEntity> findByRepairNumber(String repairNumber);
}
