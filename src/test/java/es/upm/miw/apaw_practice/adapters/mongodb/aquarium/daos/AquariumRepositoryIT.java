package es.upm.miw.apaw_practice.adapters.mongodb.aquarium.daos;
import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.entities.AquariumEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@TestConfig
public class AquariumRepositoryIT {
    @Autowired AquariumRepository aquariumRepository;

    @Test
    void findByDescription() {
        assertTrue(this.aquariumRepository.findByDescription("Sea").isPresent());
        AquariumEntity aquarium = this.aquariumRepository.findByDescription("Sea").get();
        assertEquals(2000.55,aquarium.getSize());
        assertEquals(5000,aquarium.getmaximumFishCapacity());
    }
}
