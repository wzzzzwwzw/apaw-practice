package es.upm.miw.apaw_practice.adapters.rest.olympic_games;

import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.OlympicGamesSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import static es.upm.miw.apaw_practice.adapters.rest.olympic_games.DisciplineResource.*;

@RestTestConfig
class DisciplineResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private OlympicGamesSeederService olympicGamesSeederService;

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(DISCIPLINE + NAME_ID, "Judo")
                .exchange()
                .expectStatus().isOk();
        olympicGamesSeederService.reSeedDatabase();
    }
}
