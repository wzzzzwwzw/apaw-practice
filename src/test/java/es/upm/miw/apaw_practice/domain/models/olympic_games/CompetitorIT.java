package es.upm.miw.apaw_practice.domain.models.olympic_games;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CompetitorIT {

    @Test
    void testCompetitorBuilder() {
        Competitor competitor = new Competitor.Builder()
                .name("Javier")
                .nationality("Spanish")
                .age(23)
                .build();
        assertNotNull(competitor);
        assertEquals("Javier", competitor.getName());
        assertEquals("Spanish", competitor.getNationality());
        assertEquals(23, competitor.getAge());
    }
}
