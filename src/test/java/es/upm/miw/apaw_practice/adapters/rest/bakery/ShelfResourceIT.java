package es.upm.miw.apaw_practice.adapters.rest.bakery;

import es.upm.miw.apaw_practice.adapters.mongodb.bakery.BakerySeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.bakery.Shelf;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
class ShelfResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private BakerySeederService bakerySeederService;

    @BeforeEach
    void resetDb() {
        this.bakerySeederService.deleteAll();
        this.bakerySeederService.seedDatabase();
    }

    @Test
    void testUpdate() {
        Shelf newShelf = new Shelf("EstanteriaModificada", 900, 1000, "Pasillo Modificado", null);
        this.webTestClient
                .put()
                .uri(ShelfResource.SHELVES + ShelfResource.NAME_ID, "Estanteria1")
                .body(BodyInserters.fromValue(newShelf))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Shelf.class)
                .value(Assertions::assertNotNull)
                .value(shelf -> {
                    assertEquals("EstanteriaModificada", shelf.getName());
                    assertEquals(900, shelf.getMaxCapacity());
                    assertEquals(1000, shelf.getShelves());
                    assertEquals("Pasillo Modificado", shelf.getLocation());
                    assertEquals(null, shelf.getProducts());
                });
    }
}