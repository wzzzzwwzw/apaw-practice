package es.upm.miw.apaw_practice.adapters.mongodb.hotel.dao;

import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelBookingEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface HotelBookingRepository extends MongoRepository<HotelBookingEntity, String> {
    Optional<HotelBookingEntity> findByBookingNumber(Integer number);
}
