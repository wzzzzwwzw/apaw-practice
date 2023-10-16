package es.upm.miw.apaw_practice.domain.services.airport;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.AirportSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.airport.AirLine;
import es.upm.miw.apaw_practice.domain.models.airport.Aircraft;
import es.upm.miw.apaw_practice.domain.persistence_ports.aiport.AirLinePersistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class AirLineServiceIT {
    @Autowired
    private AirLineService airLineService;
    @Autowired
    private AirLinePersistence airLinePersistence;
    @Autowired
    private AirportSeederService airportSeederService;
    @AfterEach
    void resetDataBase() {
        this.airportSeederService.deleteAll();
        this.airportSeederService.seedDatabase();
    }
    @Test
    void testUpdate(){
        List<Aircraft> aircraftList = new ArrayList<>();
        Aircraft aircraft = new Aircraft(LocalDate.of(2023, 10, 10), 420, "Boeing 747","431GBN");
        aircraftList.add(aircraft);
        AirLine airLine = this.airLineService.updateAircrafts("Iberia",aircraftList);
        assertEquals(aircraft.toString(), airLine.getAircrafts().get(0).toString());

    }

    @Test
    void testUpdateFailed(){
        List<Aircraft> aircraftList = new ArrayList<>();
        Aircraft aircraft = new Aircraft(LocalDate.of(2023, 10, 10), 420, "Boeing 747", "LKM231");
        aircraftList.add(aircraft);
        RuntimeException exception = assertThrows(NotFoundException.class, () -> {
            this.airLineService.updateAircrafts("British Airways",aircraftList);
        });
        assertTrue(exception.getMessage().contains("AirLine with name: British Airways"));
    }
}
