package es.upm.miw.apaw_practice.adapters.rest.formula_one;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.formula_one.EngineManufacturer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.List;

import static es.upm.miw.apaw_practice.adapters.rest.formula_one.EngineManufacturerResource.ENGINE_MANUFACTURERS;
import static es.upm.miw.apaw_practice.adapters.rest.formula_one.EngineManufacturerResource.SEARCH;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void testFindManufacturersNamesByHostCountry() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(ENGINE_MANUFACTURERS + SEARCH)
                                .queryParam("q", "hostCountry:USA")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .value(manufacturersNames -> assertTrue(manufacturersNames.get(0).contains("Honda")))
                .value(manufacturersNames -> assertTrue(manufacturersNames.get(0).contains("Mercedes")));
    }

    @Test
    void testNotFindManufacturersNamesByHostCountry() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(ENGINE_MANUFACTURERS + SEARCH)
                                .queryParam("q", "hostCountry:Chile")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(List.class)
                .value(list -> assertTrue(list.isEmpty()));
    }

    @Test
    void testFindManufacturersNamesByHostCountryBadRequest() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(ENGINE_MANUFACTURERS + SEARCH)
                                .queryParam("q", "hostCount:Chile")
                                .build())
                .exchange()
                .expectStatus().isBadRequest();
    }
}
