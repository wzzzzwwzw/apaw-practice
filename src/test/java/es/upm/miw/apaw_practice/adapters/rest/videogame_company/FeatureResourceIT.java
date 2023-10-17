package es.upm.miw.apaw_practice.adapters.rest.videogame_company;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.VideogameCompanySeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.videogame_company.Feature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RestTestConfig
public class FeatureResourceIT{
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
    void testUpdateCloudSynchronization(){
        this.webTestClient
                .put()
                .uri(FeatureResource.FEATURES + FeatureResource.GENRE + FeatureResource.CLOUD_SYNCHRONIZATION,
                        "Action")
                .body(BodyInserters.fromValue(true))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Feature.class)
                .value(Assertions::assertNotNull)
                .value(
                        feature -> {
                            assertEquals("Turn Based", feature.getGameStyle());
                            assertEquals(true, feature.getCloudSynchronization());
                        }
                );
    }

    @Test
    void testUpdateCloudSynchronizationNotFound(){
        this.webTestClient
                .put()
                .uri(FeatureResource.FEATURES + FeatureResource.GENRE + FeatureResource.CLOUD_SYNCHRONIZATION,
                        "Horror")
                .body(BodyInserters.fromValue(true))
                .exchange()
                .expectStatus()
                .isNotFound();
    }
}
