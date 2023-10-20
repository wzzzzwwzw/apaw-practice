package es.upm.miw.apaw_practice.adapters.rest.football_competition;

import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.FootballCompetitionSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.football_competition.FootballTeam;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
class FootballTeamResourceIT {
    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private FootballCompetitionSeederService footballCompetitionSeederService;

    @AfterEach
    void after() {
        this.footballCompetitionSeederService.deleteAll();
        this.footballCompetitionSeederService.seedDatabase();
    }

    @Test
    void testGetByCity() {
        this.webTestClient
                .get()
                .uri(FootballTeamResource.TEAMS + FootballTeamResource.CITY_ID, "Madrid")
                .exchange()
                .expectStatus().isOk()
                .expectBody(FootballTeam.class)
                .value(Assertions::assertNotNull)
                .value(team -> {
                   assertEquals("Madrid", team.getCity());
                   assertEquals(1900, team.getFoundationYear());
                   assertEquals(new BigDecimal("1238333.23"), team.getBudget());
                   assertEquals(false, team.isRemoved());
                });
    }

    @Test
    void testCreateFootballTeam() {
        FootballTeam footballTeam = new FootballTeam("Albacete", 1890, new BigDecimal("123922.16"), false);

        this.webTestClient
                .post()
                .uri(FootballTeamResource.TEAMS)
                .body(BodyInserters.fromValue(footballTeam))
                .exchange()
                .expectStatus().isOk()
                .expectBody(FootballTeam.class)
                .value(Assertions::assertNotNull);
    }
}
