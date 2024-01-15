package es.upm.miw.apaw_practice.adapters.rest.furniture_store;

import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.FurnitureStoreSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.furniture_store.Material;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Objects;

import static es.upm.miw.apaw_practice.adapters.rest.furniture_store.MaterialResource.MATERIALS;
import static es.upm.miw.apaw_practice.adapters.rest.furniture_store.MaterialResource.SEARCH;
import static org.junit.jupiter.api.Assertions.*;


@RestTestConfig
class MaterialResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private FurnitureStoreSeederService furnitureStoreSeederService;

    @BeforeEach
    void resetDB() {
        this.furnitureStoreSeederService.deleteAll();
        this.furnitureStoreSeederService.seedDatabase();
    }

    @Test
    void testCreate() {
        Material material =
                new Material("pasta dura", "porcelana", 7);
        this.webTestClient
                .post()
                .uri(MATERIALS)
                .body(BodyInserters.fromValue(material))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Material.class)
                .value(Assertions::assertNotNull)
                .value(materialData -> {
                    assertEquals(material.getName(), materialData.getName());
                    assertEquals(material.getType(), materialData.getType());
                    assertEquals(material.getDurability(), materialData.getDurability());
                });
    }

    @Test
    void testCreateConflict() {
        Material material =
                new Material("roble", "madera", 7);
        this.webTestClient
                .post()
                .uri(MATERIALS)
                .body(BodyInserters.fromValue(material))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }

    @Test
    void testFindUniqueMaterialsTypeByManagerPromotionCandidateTrue() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(MATERIALS + SEARCH)
                                .queryParam("q", "promotion-candidate:true")
                                .build()
                )
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .consumeWith(materialsType -> {
                    assertEquals("[\"madera\",\"plástico\",\"metal\",\"vidrio\"]", Objects.requireNonNull(materialsType.getResponseBody()).get(0));
                    assertTrue(materialsType.getResponseBody().size()>0);

                });
    }

    @Test
    void testFindUniqueMaterialsTypeByManagerPromotionCandidateFalse() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(MATERIALS + SEARCH)
                                .queryParam("q", "promotion-candidate:false")
                                .build()
                )
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testBadRequestFindUniqueMaterialsTypeByManagerPromotionCandidate() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(MATERIALS + SEARCH)
                                .queryParam("q", "promotion-candidate:null")
                                .build())
                .exchange()
                .expectStatus().isBadRequest();
    }

}
