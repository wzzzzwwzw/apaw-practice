package es.upm.miw.apaw_practice.domain.services.football_competition;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.FootballCompetitionSeederService;
import es.upm.miw.apaw_practice.domain.models.football_competition.FootballGameDateUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.football_competition.FootballGamePersistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class FootballGameServiceIT {
    @Autowired
    private FootballGameService footballGameService;
    @Autowired
    private FootballGamePersistence footballGamePersistence;
    @Autowired
    private FootballCompetitionSeederService footballCompetitionSeederService;

    @AfterEach
    void after() {
        this.footballCompetitionSeederService.deleteAll();
        this.footballCompetitionSeederService.seedDatabase();
    }

    @Test
    void testUpdateDates() {
        List<String> identifiers = this.footballGamePersistence.getGamesIdentifiers();
        LocalDateTime[] dates = {
                LocalDateTime.of(2023, 5, 10, 21, 0),
                LocalDateTime.of(2023, 5, 11, 21, 0),
                LocalDateTime.of(2023, 5, 12, 21, 0),
        };
        FootballGameDateUpdating[] updates = {
                new FootballGameDateUpdating(identifiers.get(0), dates[0]),
                new FootballGameDateUpdating(identifiers.get(1), dates[1]),
                new FootballGameDateUpdating(identifiers.get(2), dates[2]),
        };

        this.footballGameService.updateDates(Arrays.asList(updates));
        assertEquals(dates[0], this.footballGamePersistence.read(identifiers.get(0)).getDate());
        assertEquals(dates[0], this.footballGamePersistence.read(identifiers.get(0)).getDate());
        assertEquals(dates[0], this.footballGamePersistence.read(identifiers.get(0)).getDate());
    }

    @Test
    void testFindTotalBudgetByLocation() {
        assertEquals(
                new BigDecimal("20499779.34"),
                this.footballGameService.findTotalBudgetByLocation("Barcelona"));
    }
}
