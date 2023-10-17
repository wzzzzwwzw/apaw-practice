package es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.olympic_games.Competitor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class CompetitorPersistenceMongodbIT {

    @Autowired
    private CompetitorPersistenceMongodb competitorPersistence;

    @Test
    void testCreate() {
        Competitor competitor = this.competitorPersistence.create(new Competitor("Ibai", "Spain", 27));
        assertNotNull(competitor);
        assertEquals("Ibai", competitor.getName());
        assertEquals("Spain", competitor.getNationality());
        assertEquals(27, competitor.getAge());
    }

    @Test
    void testExistName() {
        assertFalse(this.competitorPersistence.existName("Fabio"));
        assertTrue(this.competitorPersistence.existName("Lebron"));
    }
}
