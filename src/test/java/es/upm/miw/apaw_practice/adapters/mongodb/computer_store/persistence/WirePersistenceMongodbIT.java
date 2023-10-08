package es.upm.miw.apaw_practice.adapters.mongodb.computer_store.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
class WirePersistenceMongodbIT {
    @Autowired
    private WirePersistenceMongodb wirePersistence;

    @Test
    void testReadNotFound() {
        assertThrows(NotFoundException.class, () -> this.wirePersistence.read(".."));
    }

    @Test
    void testReadFound() {
        assertNotNull(this.wirePersistence.read("HDMI"));
    }
}
