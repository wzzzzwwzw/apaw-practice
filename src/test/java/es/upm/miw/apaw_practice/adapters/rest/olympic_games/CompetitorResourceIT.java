package es.upm.miw.apaw_practice.adapters.rest.olympic_games;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.olympic_games.Competitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
class CompetitorResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        Competitor competitor = new Competitor("Ibai", "Spain", 27);
        this.webTestClient
                .post().
                uri(CompetitorResource.COMPETITOR).
                body(BodyInserters.fromValue(competitor))
                .exchange()
                .expectStatus().isOk().
                expectBody(Competitor.class).
                value(Assertions::assertNotNull);
    }

    @Test
    void testCreateError() {
        Competitor competitor = new Competitor("Lebron", "Spain", 27);
        this.webTestClient
                .post().
                uri(CompetitorResource.COMPETITOR).
                body(BodyInserters.fromValue(competitor))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }
}

