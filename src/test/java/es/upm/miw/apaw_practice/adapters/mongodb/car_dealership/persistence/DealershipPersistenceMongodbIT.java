package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.car_dealership.Dealership;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class DealershipPersistenceMongodbIT {

    @Autowired
    private DealershipPersistenceMongodb dealershipPersistenceMongodb;

    @Test
    void testRead() {
        Optional<Dealership> dealership = this.dealershipPersistenceMongodb.readAll()
                .filter(dealership1 -> "Miña Car".equals(dealership1.getName()))
                .findFirst();
        assertTrue(dealership.isPresent());
        assertEquals("Malaga", dealership.get().getCity());
        assertEquals(3, dealership.get().getCarList().size());
    }
}
