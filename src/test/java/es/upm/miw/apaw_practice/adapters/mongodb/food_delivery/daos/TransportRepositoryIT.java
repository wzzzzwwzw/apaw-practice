package es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.entities.TransportEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class TransportRepositoryIT {

    @Autowired
    private TransportRepository transportRepository;

    @Test
    void testFindByCode() {
        assertTrue(this.transportRepository.findByCode("T003").isPresent());
        TransportEntity transport = this.transportRepository.findByCode("T003").get();
        assertEquals("DEF456", transport.getLicensePlate());
        assertEquals(1, transport.getRestaurants().size());
        assertEquals("Asian Fusion", transport.getRestaurants().get(0).getName());
        assertEquals(0, new BigDecimal("35.0").compareTo(transport.getCapacity()));
    }
}
