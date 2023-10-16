package es.upm.miw.apaw_practice.adapters.rest.olympic_games;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.olympic_games.OlympicGames;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static es.upm.miw.apaw_practice.adapters.rest.olympic_games.OlympicGamesResource.*;

@RestTestConfig
class OlympicGamesResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadByEdition() {
        this.webTestClient
                .get()
                .uri(OLYMPIC_GAMES + EDITION_ID, 25)
                .exchange()
                .expectStatus().isOk()
                .expectBody(OlympicGames.class)
                .value(Assertions::assertNotNull)
                .value(olympicGamesData -> {
                    assertEquals("Barcelona", olympicGamesData.getHostingPlace());
                    assertEquals(LocalDate.of(1992,7,25), olympicGamesData.getStartDate());
                    assertTrue(olympicGamesData.getSummerGames());
                    assertEquals(4, olympicGamesData.getDisciplines().size());
                });
    }

    @Test
    void testReadByEditionError() {
        this.webTestClient
                .get()
                .uri(OLYMPIC_GAMES + EDITION_ID, 17)
                .exchange()
                .expectStatus().isNotFound();
    }
}
