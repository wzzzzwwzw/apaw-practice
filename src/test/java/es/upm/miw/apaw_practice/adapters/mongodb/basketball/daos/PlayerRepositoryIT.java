package es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.PlayerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class PlayerRepositoryIT {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void testFindByEmail() {
        Optional<PlayerEntity> result = this.playerRepository.findByEmail("email1@gmail.com");
        assertTrue(result.isPresent());
        assertEquals("alero", result.get().getPosition());
        assertEquals(19, result.get().getAge());
    }

    @Test
    void testCreateAndRead() {
        Optional<PlayerEntity> result = this.playerRepository.findByEmail("email2@gmail.com");
        assertTrue(result.isPresent());
        assertEquals("base", result.get().getPosition());
        assertEquals(20, result.get().getAge());
    }

}
