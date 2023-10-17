package es.upm.miw.apaw_practice.adapters.mongodb.hotel.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelActivityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface HotelActivityRepository extends MongoRepository<HotelActivityEntity, String> {
    Optional<HotelActivityEntity> findByInstructor(String instructor);
}
