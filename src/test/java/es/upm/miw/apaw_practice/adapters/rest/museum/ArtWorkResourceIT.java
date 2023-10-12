package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.museum.ArtWork;
import es.upm.miw.apaw_practice.domain.models.museum.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

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

    @Test
    void testCreate() {
        Room room = new Room("Sala 009", 1, 7.25);
        ArtWork artWork = new ArtWork("P001248", "Hércules desvía el curso del río Alfeo", 1634, true, room);

        this.webTestClient
                .post()
                .uri(ArtWorkResource.ARTWORKS)
                .body(BodyInserters.fromValue(artWork))
                .exchange()
                .expectStatus().isOk()
                .expectBody(ArtWork.class)
                .value(Assertions::assertNotNull)
                .value(response -> assertEquals(artWork.getInventoryNumber(), response.getInventoryNumber()))
                .value(response -> assertEquals(artWork.getTitle(), response.getTitle()))
                .value(response -> assertEquals(artWork.getApproximateYear(), response.getApproximateYear()))
                .value(response -> assertEquals(artWork.isExhibited(), response.isExhibited()))
                .value(response -> assertEquals(room.getDescription(), artWork.getRoom().getDescription()))
                .value(response -> assertEquals(room.getFloor(), artWork.getRoom().getFloor()))
                .value(response -> assertEquals(room.getPopularity(), artWork.getRoom().getPopularity()));
    }

    @Test
    void testCreateConflict() {
        Room room = new Room("Sala 012", 1, 9.75);
        ArtWork artWork = new ArtWork("P001174", "Las Meninas (con conflicto)", 1656, true, room);

        this.webTestClient
                .post()
                .uri(ArtWorkResource.ARTWORKS)
                .body(BodyInserters.fromValue(artWork))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }
}
