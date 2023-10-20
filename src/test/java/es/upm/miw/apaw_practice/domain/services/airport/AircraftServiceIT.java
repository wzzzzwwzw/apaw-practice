package es.upm.miw.apaw_practice.domain.services.airport;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.AirportSeederService;
import es.upm.miw.apaw_practice.domain.persistence_ports.aiport.AircraftPersistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@TestConfig
public class AircraftServiceIT {
    @Autowired
    private AircraftService aircraftService;
    @Autowired
    private AircraftPersistence aircraftPersistence;
    @Autowired
    private AirportSeederService airportSeederService;
    @AfterEach
    void resetDataBase() {
        this.airportSeederService.deleteAll();
        this.airportSeederService.seedDatabase();
    }
    @Test
    void testDelete(){
        this.aircraftService.delete("320POY");
    }
}
