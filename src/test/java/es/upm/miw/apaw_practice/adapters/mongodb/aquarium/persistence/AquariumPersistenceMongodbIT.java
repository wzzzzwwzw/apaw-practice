package es.upm.miw.apaw_practice.adapters.mongodb.aquarium.persistence;
import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import es.upm.miw.apaw_practice.domain.models.aquarium.Aquarium;

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
    @Test
    void testCreateAquarium() {
        Aquarium aquarium = this.aquariumPersistence.create(new Aquarium("Sea", 2000.55,5000));
        Aquarium createdAquarium = this.aquariumPersistence.create(aquarium);
        assertNotNull(createdAquarium);
        assertEquals(aquarium.getDescription(), createdAquarium.getDescription());
        assertEquals(aquarium.getSize(), createdAquarium.getSize());
        assertEquals(aquarium.getMaximumFishCapacity(),aquarium.getMaximumFishCapacity());
    }

    @Test
    void testExistAquariumDescription() {
        assertTrue(this.aquariumPersistence.existsAquariumDescription("Sea"));
    }

    @Test
    void testNotExistWireName() {
        assertFalse(this.aquariumPersistence.existsAquariumDescription("No exist"));
    }
}
