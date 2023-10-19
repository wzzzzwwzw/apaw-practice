package es.upm.miw.apaw_practice.adapters.rest.basketball;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.basketball.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static es.upm.miw.apaw_practice.adapters.rest.basketball.TeamBasketballResource.*;
import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
class TeamResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testRead() {
        this.webTestClient
                .get()
                .uri(TEAMSBASKETBALL + ALIAS_ID, "alias1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Team.class)
                .value(Assertions::assertNotNull)
                .value(teamData -> {
                    assertEquals("alias1", teamData.getAlias());
                    assertEquals(2, teamData.getNumPlayers());
                    assertEquals("Alberto", teamData.getCoach());
                    assertEquals("email1@gmail.com", teamData.getPlayers().get(0).getEmail());
                    assertEquals("pavilion1", teamData.getPavilions().get(0).getPavname());
                });
    }
}
