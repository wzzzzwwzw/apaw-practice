package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.FootballCompetitionSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballCompetitionEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballTeamEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class FootballCompetitionRepositoryIT {
    @Autowired
    private FootballCompetitionRepository footballCompetitionRepository;
    @Autowired
    private FootballCompetitionSeederService footballCompetitionSeederService;

    @AfterEach
    void after() {
        this.footballCompetitionSeederService.deleteAll();
        this.footballCompetitionSeederService.seedDatabase();
    }

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

    @Test
    void testDelete() {
        assertTrue(this.footballCompetitionRepository.findByOrganizingEntity("FFF").isPresent());
        FootballCompetitionEntity competition = this.footballCompetitionRepository
                .findByOrganizingEntity("FFF").get();
        this.footballCompetitionRepository.delete(competition);
        assertEquals(Optional.empty(), this.footballCompetitionRepository.findByOrganizingEntity("FFF"));
    }
}
