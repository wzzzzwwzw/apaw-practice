package es.upm.miw.apaw_practice.adapters.mongodb.hotel.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelBookingEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface HotelBookingRepository extends MongoRepository<HotelBookingEntity, Integer> {
    Optional<HotelBookingEntity> findByNumber(Integer number);
}
