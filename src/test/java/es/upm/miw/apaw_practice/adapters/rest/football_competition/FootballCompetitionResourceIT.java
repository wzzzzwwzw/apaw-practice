package es.upm.miw.apaw_practice.adapters.rest.football_competition;

import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.FootballCompetitionSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

@RestTestConfig
public class FootballCompetitionResourceIT {
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
    public void testDeleteFootballCompetition() {
        this.webTestClient
                .delete()
                .uri(FootballCompetitionResource.COMPETITIONS + FootballCompetitionResource.ORGANIZING_ENTITY_ID, "PFF")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testGetNamesByOrganizingEntity() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(FootballCompetitionResource.COMPETITIONS + FootballCompetitionResource.SEARCH)
                                .queryParam("organizingEntity", "FFF")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .returnResult()
                .getResponseBody()
                .equals(List.of("Luka Modric", "Lionel Messi"));
    }
}
