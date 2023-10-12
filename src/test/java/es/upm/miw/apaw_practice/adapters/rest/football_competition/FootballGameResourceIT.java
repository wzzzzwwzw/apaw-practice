package es.upm.miw.apaw_practice.adapters.rest.football_competition;

import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.persistence.FootballGamePersistenceMongodb;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.football_competition.FootballGameDateUpdating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDateTime;
import java.util.List;

@RestTestConfig
public class FootballGameResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private FootballGamePersistenceMongodb footballGamePersistence;

    @Test
    public void testPatch() {
        List<String> identifiers = this.footballGamePersistence.getGamesIdentifiers();
        List<FootballGameDateUpdating> gameDateUpdatings = identifiers.stream()
                .map(id -> new FootballGameDateUpdating(id, LocalDateTime.of(2023, 4, 1, 21, 0)))
                .toList();

        this.webTestClient
                .patch()
                .uri(FootballGameResource.GAMES)
                .body(BodyInserters.fromValue(gameDateUpdatings))
                .exchange()
                .expectStatus().isOk();
    }
}
