package es.upm.miw.apaw_practice.adapters.mongodb.aquarium.daos;
import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.entities.AquariumCuratorEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.entities.FishpondEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@TestConfig
public class FishpondRepositoryIT {
    @Autowired
    FishpondRepository fishpondRepository;

    @Test
    void FindByDirection() {
        assertTrue(this.fishpondRepository.findByDirection("First floor").isPresent());
        FishpondEntity fishpond = this.fishpondRepository.findByDirection("First floor").get();
        assertEquals(110, fishpond.getFishId());
        assertEquals(LocalDate.of(2023, 8, 13), fishpond.getOpenTime());
        assertEquals(1, fishpond.getFishEntities().size());
        this.assertFishpond(fishpond, "Catfish");
    }
        private void assertFishpond(FishpondEntity fishpond, String species){
            assertTrue(fishpond.getFishEntities()
                    .stream()
                    .anyMatch(fish ->
                            fish.getSpecies().equals(species)
                    )
            );
        }
    }

