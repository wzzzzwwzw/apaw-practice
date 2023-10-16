package es.upm.miw.apaw_practice.adapters.mongodb.airport.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.AirLineEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.AircraftEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface AircraftRepository extends MongoRepository<AircraftEntity, String> {
    int deleteByNumberPlate(String numberPlate);
}
