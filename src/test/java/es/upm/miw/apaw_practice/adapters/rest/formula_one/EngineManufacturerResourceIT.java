package es.upm.miw.apaw_practice.adapters.rest.formula_one;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.formula_one.EngineManufacturer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static es.upm.miw.apaw_practice.adapters.rest.formula_one.EngineManufacturerResource.ENGINE_MANUFACTURERS;

@RestTestConfig
public class EngineManufacturerResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        EngineManufacturer engineManufacturer = new EngineManufacturer("Renault", "France", 0);
        this.webTestClient
                .post()
                .uri(ENGINE_MANUFACTURERS)
                .body(BodyInserters.fromValue(engineManufacturer))
                .exchange()
                .expectStatus().isOk()
                .expectBody(EngineManufacturer.class)
                .value(Assertions::assertNotNull);
    }

    @Test
    void testCreateConflict() {
        EngineManufacturer engineManufacturer = new EngineManufacturer("Honda", "Japan", 6);
        this.webTestClient
                .post()
                .uri(ENGINE_MANUFACTURERS)
                .body(BodyInserters.fromValue(engineManufacturer))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }
}
