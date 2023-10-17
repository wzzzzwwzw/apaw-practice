package es.upm.miw.apaw_practice.adapters.rest.football_competition;

import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.FootballCompetitionSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.football_competition.FootballPlayer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
class FootballPlayerResourceIT {
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
    void testUpdateGoals() {
        this.webTestClient
                .put()
                .uri(FootballPlayerResource.PLAYERS + FootballPlayerResource.NAME_ID + FootballPlayerResource.GOALS, "Lionel Messi")
                .body(BodyInserters.fromValue(30))
                .exchange()
                .expectStatus().isOk()
                .expectBody(FootballPlayer.class)
                .value(Assertions::assertNotNull)
                .value(player -> {
                    assertEquals("Lionel Messi", player.getName());
                    assertEquals(new BigDecimal("928383.02"), player.getSalary());
                    assertEquals((float)1.70, player.getHeight());
                    assertEquals(30, player.getGoals());
                    assertEquals(20, player.getAssists());
                    assertNotNull(player.getTeam());
                });
    }
}
