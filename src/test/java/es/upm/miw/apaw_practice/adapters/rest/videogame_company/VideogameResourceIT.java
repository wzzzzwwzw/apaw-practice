package es.upm.miw.apaw_practice.adapters.rest.videogame_company;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.VideogameCompanySeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class VideogameResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private VideogameCompanySeederService videogameCompanySeederService;

    @AfterEach
    void resetDatabase(){
        this.videogameCompanySeederService.deleteAll();
        this.videogameCompanySeederService.seedDatabase();
    }

    @Test
    void testDelete(){
        this.webTestClient
                .delete()
                .uri(VideogameResource.VIDEOGAMES + VideogameResource.NAME_ID, "Pyre")
                .exchange()
                .expectStatus().isOk();
    }

}
