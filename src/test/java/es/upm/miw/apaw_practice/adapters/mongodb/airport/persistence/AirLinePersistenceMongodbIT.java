package es.upm.miw.apaw_practice.adapters.mongodb.airport.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.airport.AirLine;
import es.upm.miw.apaw_practice.domain.models.airport.Aircraft;
import es.upm.miw.apaw_practice.domain.models.airport.Passenger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class AirLinePersistenceMongodbIT {
    @Autowired
    private AirLinePersistenceMongodb airLinePersistenceMongodb;

    @Test
    void testUpdate(){
        AirLine airLineOriginal = this.airLinePersistenceMongodb.readByName("Iberia");
        int sizeOriginal = airLineOriginal.getAircrafts().size();
        Aircraft aircraft = new Aircraft(LocalDate.of(2023, 10, 10), 420, "Boeing 747");
        airLineOriginal.getAircrafts().add(aircraft);
        AirLine airLineUpdate = this.airLinePersistenceMongodb.update(airLineOriginal);
        assertEquals(aircraft.toString(),airLineUpdate.getAircrafts().get(sizeOriginal).toString());
    }
    @Test
    void testUpdateNotFound() {
        AirLine airLine = new AirLine("British Airways", LocalDate.of(1972, 6, 11), null);
        RuntimeException exception = assertThrows(NotFoundException.class, () -> {
            this.airLinePersistenceMongodb.update(airLine);
        });
        assertTrue(exception.getMessage().contains("AirLine with name: British Airways"));
    }
    @Test
    void testReadByName(){
        AirLine airLine = this.airLinePersistenceMongodb.readByName("Iberia");
        assertEquals(LocalDate.of(1927, 6, 28), airLine.getDayOfFoundation());
    }
    @Test
    void testReadNotFound() {
        RuntimeException exception = assertThrows(NotFoundException.class, () -> {
            this.airLinePersistenceMongodb.readByName("British Airways");
        });
        assertTrue(exception.getMessage().contains("AirLine with name: British Airways"));
    }

}
