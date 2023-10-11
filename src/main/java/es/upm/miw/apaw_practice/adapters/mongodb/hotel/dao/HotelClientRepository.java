package es.upm.miw.apaw_practice.adapters.mongodb.hotel.dao;

import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelClientRepository extends MongoRepository<HotelClientEntity, String> {
}
