package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.museum.ArtWork;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
public class ArtWorkResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testRead() {
        this.webTestClient
                .get()
                .uri(ArtWorkResource.ARTWORKS + ArtWorkResource.INVENTORY_NUMBER_ID, "P001174")
                .exchange()
                .expectStatus().isOk()
                .expectBody(ArtWork.class)
                .value(Assertions::assertNotNull)
                .value(artWork -> assertEquals("Las Meninas", artWork.getTitle()))
                .value(artWork -> assertEquals(1656, artWork.getApproximateYear()))
                .value(artWork -> assertTrue(artWork.isExhibited()))
                .value(artWork -> assertEquals("Sala 012", artWork.getRoom().getDescription()))
                .value(artWork -> assertEquals(1, artWork.getRoom().getFloor()))
                .value(artWork -> assertEquals(9.75, artWork.getRoom().getPopularity()));
    }

    @Test
    void testReadNotFound() {
        this.webTestClient
                .get()
                .uri(ArtWorkResource.ARTWORKS + ArtWorkResource.INVENTORY_NUMBER_ID, "P000001")
                .exchange()
                .expectStatus().isNotFound()
                .expectBody();
    }
}
