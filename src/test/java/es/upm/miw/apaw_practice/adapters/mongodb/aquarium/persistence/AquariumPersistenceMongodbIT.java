package es.upm.miw.apaw_practice.adapters.mongodb.aquarium.persistence;
import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.AirportSeederService;
import org.junit.jupiter.api.AfterEach;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import es.upm.miw.apaw_practice.domain.models.aquarium.Aquarium;

import static org.junit.jupiter.api.Assertions.*;
@TestConfig
class AquariumPersistenceMongodbIT {
    @Autowired
    private AquariumPersistenceMongodb aquariumPersistenceMongodb;
    @Autowired
    private AirportSeederService airportSeederService;
    @AfterEach
    void resetDataBase(){
        this.airportSeederService.deleteAll();
        this.airportSeederService.seedDatabase();
    }
    @Test
    void testReadNotFound(){
        assertThrows(NotFoundException.class,()->this.aquariumPersistenceMongodb.read(".."));
    }
    @Test
    void testReadFound(){
        assertNotNull(this.aquariumPersistenceMongodb.read("Sea"));
    }
    @Test
    void testCreateAquarium() {
        Aquarium aquarium = this.aquariumPersistenceMongodb.create(new Aquarium("Sea", 2000.55,5000));
        Aquarium createdAquarium = this.aquariumPersistenceMongodb.create(aquarium);
        assertNotNull(createdAquarium);
        assertEquals(aquarium.getDescription(), createdAquarium.getDescription());
        assertEquals(aquarium.getSize(), createdAquarium.getSize());
        assertEquals(aquarium.getMaximumFishCapacity(),aquarium.getMaximumFishCapacity());
    }

    @Test
    void testExistAquariumDescription() {
        assertTrue(this.aquariumPersistenceMongodb.existsAquariumDescription("Sea"));
    }

    @Test
    void testNotExistWireName() {
        assertFalse(this.aquariumPersistenceMongodb.existsAquariumDescription("No exist"));
    }
    @Test
    void testUpdate(){
        Aquarium aquarium = this.aquariumPersistenceMongodb.read("Sea");
        aquarium.setSize(2000.55);
        Aquarium aquariumUpdated = this.aquariumPersistenceMongodb.update(aquarium);
        assertEquals("Sea",aquariumUpdated.getDescription());
        assertEquals(2000.55,aquariumUpdated.getSize());
    }
}
