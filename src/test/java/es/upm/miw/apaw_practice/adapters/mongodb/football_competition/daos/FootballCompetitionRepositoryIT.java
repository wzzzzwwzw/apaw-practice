package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballCompetitionEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballTeamEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class FootballCompetitionRepositoryIT {
    @Autowired
    private FootballCompetitionRepository footballCompetitionRepository;

    @Test
    void testFindByOrganizingEntity() {
        assertTrue(this.footballCompetitionRepository.findByOrganizingEntity("RFEF").isPresent());
        FootballCompetitionEntity footballCompetition =
                this.footballCompetitionRepository.findByOrganizingEntity("RFEF").get();

        assertEquals(new BigDecimal("1000000.00"), footballCompetition.getPrize());
        assertEquals("RFEF", footballCompetition.getOrganizingEntity());
        assertNotNull(footballCompetition.getSponsors());
        assertNotNull(footballCompetition.getTeams());

        assertTrue(footballCompetition.getSponsors()
                .containsAll(Arrays.asList("BBVA", "Nike")));
        assertTrue(footballCompetition.getTeams().stream()
                .map(FootballTeamEntity::getCity)
                .toList()
                .containsAll(Arrays.asList("Madrid", "Barcelona", "Valencia", "Zaragoza")));
    }
}
