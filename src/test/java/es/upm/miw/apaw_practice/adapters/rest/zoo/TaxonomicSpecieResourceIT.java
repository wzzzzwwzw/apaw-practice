package es.upm.miw.apaw_practice.adapters.rest.zoo;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.zoo.TaxonomicSpecie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
public class TaxonomicSpecieResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        TaxonomicSpecie taxonomicSpecie =
                new TaxonomicSpecie("homo", "habilis", true, "Africa");
        this.webTestClient
                .post()
                .uri(TaxonomicSpecieResource.TAXONOMICSPECIE)
                .body(BodyInserters.fromValue(taxonomicSpecie))
                .exchange()
                .expectStatus().isOk()
                .expectBody(TaxonomicSpecie.class)
                .value(Assertions::assertNotNull);
    }

    @Test
    void testCreateConflict() {
        TaxonomicSpecie taxonomicSpecie =
                new TaxonomicSpecie("Canis", "lupus", false, "forests, inland wetlands, shrublands, grasslands, pastures, deserts, rocky peaks ");
        this.webTestClient
                .post()
                .uri(TaxonomicSpecieResource.TAXONOMICSPECIE)
                .body(BodyInserters.fromValue(taxonomicSpecie))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }
}
