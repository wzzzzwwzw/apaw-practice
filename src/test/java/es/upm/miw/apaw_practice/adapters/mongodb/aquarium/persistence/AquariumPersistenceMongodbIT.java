package es.upm.miw.apaw_practice.adapters.mongodb.aquarium.persistence;
import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
@TestConfig
class AquariumPersistenceMongodbIT {
    @Autowired
    private AquariumPersistenceMongodb aquariumPersistence;
    @Test
    void testReadNotFound(){
        assertThrows(NotFoundException.class,()->this.aquariumPersistence.read(".."));
    }
    @Test
    void testReadFound(){
        assertNotNull(this.aquariumPersistence.read("Sea"));
    }
}
