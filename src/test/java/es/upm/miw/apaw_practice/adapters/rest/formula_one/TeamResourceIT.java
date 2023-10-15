package es.upm.miw.apaw_practice.adapters.rest.formula_one;

import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.FormulaOneSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static es.upm.miw.apaw_practice.adapters.rest.formula_one.TeamResource.TEAMS;
import static es.upm.miw.apaw_practice.adapters.rest.formula_one.TeamResource.TEAM_NAME_ID;

@RestTestConfig
public class TeamResourceIT {

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private FormulaOneSeederService formulaOneSeederService;

    @AfterEach
    void resetDataBase() {
        this.formulaOneSeederService.deleteAll();
        this.formulaOneSeederService.seedDatabase();
    }

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(TEAMS + TEAM_NAME_ID, "Red Bull")
                .exchange()
                .expectStatus().isOk();
    }
}
