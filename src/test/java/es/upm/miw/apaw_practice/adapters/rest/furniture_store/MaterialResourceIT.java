package es.upm.miw.apaw_practice.adapters.rest.furniture_store;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.furniture_store.Material;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static es.upm.miw.apaw_practice.adapters.rest.furniture_store.MaterialResource.MATERIAL;
import static org.junit.jupiter.api.Assertions.assertEquals;


@RestTestConfig
class MaterialResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        Material material =
                new Material("pasta dura", "porcelana", 7);
        this.webTestClient
                .post()
                .uri(MATERIAL)
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
                .uri(MATERIAL)
                .body(BodyInserters.fromValue(material))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }

}
