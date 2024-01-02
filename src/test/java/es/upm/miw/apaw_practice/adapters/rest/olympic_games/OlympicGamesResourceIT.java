package es.upm.miw.apaw_practice.adapters.rest.olympic_games;

import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.OlympicGamesSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.olympic_games.OlympicGames;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static es.upm.miw.apaw_practice.adapters.rest.olympic_games.OlympicGamesResource.*;
import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
class OlympicGamesResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private OlympicGamesSeederService olympicGamesSeederService;

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

    @Test
    void testUpdateHostingPlace() {
        this.webTestClient
                .patch()
                .uri(OLYMPIC_GAMES + EDITION_ID + HOSTING_PLACE, 1)
                .body(BodyInserters.fromValue("Rome"))
                .exchange()
                .expectStatus().isOk()
                .expectBody(OlympicGames.class)
                .value(Assertions::assertNotNull)
                .value(olympicGames -> {
                    assertEquals("Rome", olympicGames.getHostingPlace());
                    assertTrue(olympicGames.getSummerGames());
                    assertEquals(LocalDate.of(1896,4,5), olympicGames.getStartDate());
                    assertEquals(2, olympicGames.getDisciplines().size());
                });
        olympicGamesSeederService.reSeedDatabase();
    }
    @Test
    void testUpdateHostingPlaceError() {
        this.webTestClient
                .patch()
                .uri(OLYMPIC_GAMES + EDITION_ID + HOSTING_PLACE, 17)
                .body(BodyInserters.fromValue("Rome"))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testFindHostingPlaceByCompetition() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(OLYMPIC_GAMES + SEARCH)
                                .queryParam("q", "competition:4x100m relays")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class)
                .value(Assertions::assertNotNull)
                .value(hostingPlaces -> {
                    List<String> expectedHostingPlaces = Arrays.asList("Athens", "London", "Barcelona");
                    assertIterableEquals(expectedHostingPlaces, hostingPlaces);
                });
    }
}
