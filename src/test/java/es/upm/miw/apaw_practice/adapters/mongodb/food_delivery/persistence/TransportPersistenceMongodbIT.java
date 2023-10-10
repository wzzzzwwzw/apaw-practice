package es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.food_delivery.Transport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class TransportPersistenceMongodbIT {

    @Autowired
    private TransportPersistenceMongodb transportPersistence;

    @Test
    void testReadByCode() {
        Transport transport = this.transportPersistence.readByCode("T001");
        assertEquals(new BigDecimal("50.0"), transport.getCapacity());
        assertEquals("ABC123", transport.getLicensePlate());


    }

    @Test
    void testUpdateAvalaible() {
        Transport transport = this.transportPersistence.readByCode("T001");
        transport.setAvalaible(false);
        this.transportPersistence.updateTransportAvalaible(transport);
        transport = this.transportPersistence.readByCode("T001");
        assertEquals(false, transport.getAvalaible());
    }


}
