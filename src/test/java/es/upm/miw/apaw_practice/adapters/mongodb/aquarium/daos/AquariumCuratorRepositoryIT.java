package es.upm.miw.apaw_practice.adapters.mongodb.aquarium.daos;
import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.entities.AquariumCuratorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class AquariumCuratorRepositoryIT {
    @Autowired AquariumCuratorRepository aquariumCuratorRepository;

    @Test
    void testFindByName() {
        assertTrue(this.aquariumCuratorRepository.findByName("Atlantis").isPresent());
        AquariumCuratorEntity aquariumCurator = this.aquariumCuratorRepository.findByName("Atlantis").get();
        assertEquals("Madrid",aquariumCurator.getPosition());
        assertFalse(aquariumCurator.getVacationState());
        assertEquals(1,aquariumCurator.getFishpondEntities().size());
        this.assertAquariumCurator(aquariumCurator,"Second floor");
        assertEquals("Sea",aquariumCurator.getAquariumEntity().getDescription());
    }
    private void assertAquariumCurator(AquariumCuratorEntity aquariumCurator, String direction) {
        assertTrue(aquariumCurator.getFishpondEntities()
                .stream()
                .anyMatch(fishpond ->
                        fishpond.getDirection().equals(direction)
                )
        );
    }
}
