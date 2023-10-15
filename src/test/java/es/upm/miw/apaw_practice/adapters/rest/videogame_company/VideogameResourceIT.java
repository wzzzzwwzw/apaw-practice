package es.upm.miw.apaw_practice.adapters.rest.videogame_company;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.VideogameCompanySeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.videogame_company.Videogame;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


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

    @Test
    void testPatch(){
        this.webTestClient
                .patch()
                .uri(VideogameResource.VIDEOGAMES + VideogameResource.NAME_ID, "Super Bomberman R")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Videogame.class)
                .value(Assertions::assertNotNull)
                .value(
                        videogame -> {
                            assertEquals("Super Bomberman R", videogame.getName());
                            assertTrue(videogame.getReleaseDate().atStartOfDay()
                                    .isEqual(LocalDate.now().atStartOfDay()));
                        }
                );
    }

}
