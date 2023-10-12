package es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.entities.CompetitorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class CompetitorRepositoryIT {

    @Autowired
    CompetitorRepository competitorRepository;

    @Test
    void testFindByName() {
        assertTrue(this.competitorRepository.findByName("Lebron").isPresent());
        CompetitorEntity competitor = this.competitorRepository.findByName("Lebron").get();
        assertEquals("United States", competitor.getNationality());
        assertEquals(36, competitor.getAge());
    }
}
