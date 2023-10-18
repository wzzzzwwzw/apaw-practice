package es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.TeamBasketballEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class TeamBasketballRepositoryIT {

    @Autowired
    private TeamBasketballRepository teamBasketballRepository;

    @Test
    void testFindByAlias() {
        Optional<TeamBasketballEntity> result = this.teamBasketballRepository.findByAlias("alias1");
        assertTrue(result.isPresent());
        assertEquals(2, result.get().getNumPlayers());
        assertEquals("Alberto", result.get().getCoach());
    }

    @Test
    void testCreateAndRead() {
        Optional<TeamBasketballEntity> result = this.teamBasketballRepository.findByAlias("alias2");
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getNumPlayers());
        assertEquals("Juan", result.get().getCoach());
    }
}
