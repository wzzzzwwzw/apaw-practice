package es.upm.miw.apaw_practice.adapters.mongodb.airport.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.AirLineEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class AirLineRepositoryIT {
    @Autowired
    private AirLineRepository airLineRepository;

    @Test
    void testFindByName() {
        assertTrue(this.airLineRepository.findByName("Iberia").isPresent());
        AirLineEntity airLine = this.airLineRepository.findByName("Iberia").get();
        assertEquals(1927, airLine.getDayOfFoundation().getYear());
        assertEquals("Airbus A320", airLine.getAircrafts().get(0).getModel());
    }
}
