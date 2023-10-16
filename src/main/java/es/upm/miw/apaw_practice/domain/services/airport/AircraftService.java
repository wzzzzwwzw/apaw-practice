package es.upm.miw.apaw_practice.domain.services.airport;

import es.upm.miw.apaw_practice.domain.persistence_ports.aiport.AircraftPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AircraftService {
    private final AircraftPersistence aircraftPersistence;
    @Autowired
    public AircraftService(AircraftPersistence aircraftPersistence){
        this.aircraftPersistence = aircraftPersistence;
    }
    public void delete(String numberPlate){
        this.aircraftPersistence.delete(numberPlate);
    }
}
