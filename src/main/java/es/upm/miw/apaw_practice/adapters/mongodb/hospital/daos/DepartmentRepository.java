package es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.DepartmentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DepartmentRepository extends MongoRepository<DepartmentEntity, String> {
    Optional<DepartmentEntity> findByDepartmentName(String departmentName);

}
