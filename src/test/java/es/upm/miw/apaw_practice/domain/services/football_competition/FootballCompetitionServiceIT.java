package es.upm.miw.apaw_practice.domain.services.football_competition;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.FootballCompetitionSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.football_competition.FootballCompetition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class FootballCompetitionServiceIT {
    @Autowired
    private FootballCompetitionService footballCompetitionService;
    @Autowired
    private FootballCompetitionSeederService footballCompetitionSeederService;

    @AfterEach
    void after() {
        this.footballCompetitionSeederService.deleteAll();
        this.footballCompetitionSeederService.seedDatabase();
    }

    @Test
    public void testGetFootballCompetitionByOrganizingEntity() {
        String organizingEntity = "PFF";
        FootballCompetition competition =
                this.footballCompetitionService.getFootballCompetitionByOrganizingEntity(organizingEntity);
        assertNotNull(competition);
        assertEquals(organizingEntity, competition.getOrganizingEntity());
        assertEquals(new BigDecimal("140000.00"), competition.getPrize());
        assertEquals(0, competition.getSponsors().size());
        assertEquals(0, competition.getTeams().size());
    }

    @Test
    public void testDelete() {
        String organizingEntity = "PDK";
        assertNotNull(this.footballCompetitionService.getFootballCompetitionByOrganizingEntity(organizingEntity));
        this.footballCompetitionService.delete(organizingEntity);
        assertThrows(
                NotFoundException.class,
                () -> this.footballCompetitionService.getFootballCompetitionByOrganizingEntity(organizingEntity));
    }

    @Test
    public void testGetNamesByOrganizingEntity() {
        String organizingEntity = "FFF";
        List<String> names = this.footballCompetitionService.getNamesByOrganizingEntity(organizingEntity);
        assertNotNull(names);
        assertEquals(List.of("Luka Modric", "Lionel Messi"), names);
    }
}
