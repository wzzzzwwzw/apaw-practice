package es.upm.miw.apaw_practice.adapters.mongodb.climbing.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.climbing.entities.ClimberEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class ClimberRepositoryIT {

    @Autowired
    private ClimberRepository climberRepository;

    @Test
    void testFindByEmail() {
        assertTrue(this.climberRepository.findByEmail("climber1@email.com").isPresent());
        ClimberEntity climber = this.climberRepository.findByEmail("climber1@email.com").get();
        assertEquals(LocalDate.of(1990, 1, 1), climber.getDateOfBirth());
    }

    @Test
    void testCreateAndRead() {
        assertTrue(this.climberRepository.findAll().stream()
                .anyMatch(climber ->
                        "climber1@email.com".equals(climber.getEmail()) &&
                                LocalDate.of(1990, 1, 1).equals(climber.getDateOfBirth())
                ));
    }
}
