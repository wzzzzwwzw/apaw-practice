package es.upm.miw.apaw_practice.adapters.rest.olympic_games;

import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.OlympicGamesSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.olympic_games.Competitor;
import es.upm.miw.apaw_practice.domain.models.olympic_games.Medal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
class MedalResourceIT {

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private OlympicGamesSeederService olympicGamesSeederService;

    @Test
    void testUpdateWinner() {
        Competitor winner = new Competitor("Keria", "Korea", 20);
        this.webTestClient
                .put()
                .uri(MedalResource.MEDAL + MedalResource.MEDAL_ID + MedalResource.WINNER, "MED222")
                .body(BodyInserters.fromValue(winner))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Medal.class)
                .value(Assertions::assertNotNull)
                .value(medal -> {
                    assertEquals("Keria", medal.getWinner().getName());
                });
        olympicGamesSeederService.reSeedDatabase();
    }

    @Test
    void testUpdateWinnerError() {
        Competitor winner = new Competitor("Keria", "Korea", 20);
        this.webTestClient
                .put()
                .uri(MedalResource.MEDAL + MedalResource.MEDAL_ID + MedalResource.WINNER, "MED456")
                .body(BodyInserters.fromValue(winner))
                .exchange()
                .expectStatus().isNotFound();
    }
}
