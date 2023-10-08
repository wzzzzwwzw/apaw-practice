package es.upm.miw.apaw_practice.adapters.mongodb.subway.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.subway.entities.ScheduleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScheduleRepository extends MongoRepository<ScheduleEntity, String> {

}
