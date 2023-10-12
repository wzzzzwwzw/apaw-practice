package es.upm.miw.apaw_practice.domain.services.olympic_games;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.olympic_games.Competitor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class CompetitorServiceIT {

    @Autowired
    private CompetitorService competitorService;

    @Test
    void testCreateCompetitor() {
        Competitor competitor = this.competitorService.create(new Competitor("Ibai", "Spain", 27));
        assertNotNull(competitor);
        assertEquals("Ibai", competitor.getName());
        assertEquals("Spain", competitor.getNationality());
        assertEquals(27, competitor.getAge());
    }

    @Test
    void testCreateCompetitorError() {
        assertThrows(ConflictException.class, () -> this.competitorService.create(new Competitor("Lebron", "Spain", 27)));
    }
}
