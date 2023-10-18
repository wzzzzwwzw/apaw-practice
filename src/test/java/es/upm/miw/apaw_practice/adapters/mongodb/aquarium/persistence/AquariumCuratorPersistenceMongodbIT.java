package es.upm.miw.apaw_practice.adapters.mongodb.aquarium.persistence;
import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.AquariumSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.daos.AquariumCuratorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.entities.AquariumCuratorEntity;
import es.upm.miw.apaw_practice.domain.models.aquarium.AquariumCurator;
import es.upm.miw.apaw_practice.domain.persistence_ports.aquarium.AquariumCuratorPersistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
@TestConfig
public class AquariumCuratorPersistenceMongodbIT {
    @Autowired
    private AquariumCuratorRepository aquariumCuratorRepository;
    @Autowired
    private AquariumCuratorPersistence aquariumCuratorPersistence;
    @Autowired
    private AquariumSeederService aquariumSeederService;

    @BeforeEach
    void CleanUpDB() {
        this.aquariumSeederService.deleteAll();
        this.aquariumSeederService.seedDatabase();
    }
    @Test
    void testReadByName(){
        assertTrue(this.aquariumCuratorRepository.findByName("Atlantis").isPresent());
        AquariumCuratorEntity aquariumCurator = this.aquariumCuratorRepository.findByName("Atlantis").get();
        assertNotNull(aquariumCurator);
        assertEquals("Madrid",aquariumCurator.getPosition());
        assertEquals(2000.55,aquariumCurator.getAquariumEntity().getSize());
        assertEquals("Sea",aquariumCurator.getAquariumEntity().getDescription());
        assertEquals(5000,aquariumCurator.getAquariumEntity().getMaximumFishCapacity());
        assertEquals(1,aquariumCurator.getFishpondEntities().size());
    }

    private void assertFishpond(AquariumCuratorEntity aquariumCurator, String i) {
        assertTrue(aquariumCurator.getFishpondEntities()
                .stream()
                .anyMatch(fishponds ->fishponds.getDirection().equals(i)));
    }
    @Test
    void testUpdate(){
        AquariumCurator aquariumCurator = this.aquariumCuratorPersistence.readByName("Atlantis");
        aquariumCurator.setPosition("Madrid");
        aquariumCurator.setVacationState(false);

        AquariumCurator aquariumCuratorChange = aquariumCuratorPersistence.update(aquariumCurator);
        assertEquals("Atlantis",aquariumCurator.getName());
        assertEquals("Madrid",aquariumCurator.getPosition());
        assertEquals("Sea",aquariumCuratorChange.getAquarium().getDescription());
        assertEquals(1,aquariumCurator.getFishponds().size());
    }
}
