package es.upm.miw.apaw_practice.adapters.rest.football_competition;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class FootballCompetitionResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testDeleteFootballCompetition() {
        this.webTestClient
                .delete()
                .uri(FootballCompetitionResource.COMPETITIONS + FootballCompetitionResource.ORGANIZING_ENTITY_ID, "PFF")
                .exchange()
                .expectStatus().isOk();
    }
}
