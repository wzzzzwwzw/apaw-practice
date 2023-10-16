package es.upm.miw.apaw_practice.adapters.mongodb.airport.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.airport.daos.AirLineRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.daos.AircraftRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.airport.Aircraft;
import es.upm.miw.apaw_practice.domain.persistence_ports.aiport.AircraftPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("aircraftPersistence")
public class AircraftPersistenceMongodb implements AircraftPersistence {
    private final AircraftRepository aircraftRepository;

    @Autowired
    public AircraftPersistenceMongodb(AircraftRepository aircraftRepository){
        this.aircraftRepository = aircraftRepository;
    }

    @Override
    public void delete(String numberPlate) {
        this.aircraftRepository.deleteByNumberPlate(numberPlate);
    }
}
