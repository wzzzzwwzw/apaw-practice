package es.upm.miw.apaw_practice.adapters.mongodb.airport.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.PassengerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@TestConfig
public class PassengerRepositoryIT {
    @Autowired
    private PassengerRepository passengerRepository;

    @Test
    void testFindByName() {
        assertTrue(this.passengerRepository.findByName("Carmen Moreno").isPresent());
        PassengerEntity passenger = this.passengerRepository.findByName("Carmen Moreno").get();
        assertEquals(20, passenger.getAge());
        assertEquals("6280942123", passenger.getNumberOfPhone());
    }
}
