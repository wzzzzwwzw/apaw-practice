package es.upm.miw.apaw_practice.adapters.rest.computer_store;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.computer_store.Wire;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
class WireResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testGetByName() {
        this.webTestClient
                .get()
                .uri(WireResource.WIRES + WireResource.NAME_ID, "HDMI")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Wire.class)
                .value(Assertions::assertNotNull)
                .value(wire -> {
                    assertEquals("HDMI", wire.getName());
                    assertEquals(new BigDecimal("1.5"), wire.getLength());
                    assertEquals("Plastic", wire.getJacketMaterial());
                });
    }

    @Test
    void testPostWire() {
        Wire wireNotExists = new Wire("notExistsWire", BigDecimal.ONE, "Plastic");
        this.webTestClient
                .post()
                .uri(WireResource.WIRES)
                .body(BodyInserters.fromValue(wireNotExists))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Wire.class)
                .value(Assertions::assertNotNull)
                .value(wire -> {
                    assertEquals(wireNotExists.getName(), wire.getName());
                    assertEquals(wireNotExists.getLength(), wire.getLength());
                    assertEquals(wireNotExists.getJacketMaterial(), wire.getJacketMaterial());
                });
    }

    @Test
    void testPostAlreadyExistWireName() {
        Wire wireNotExists = new Wire("HDMI", BigDecimal.ONE, "Plastic");
        this.webTestClient
                .post()
                .uri(WireResource.WIRES)
                .body(BodyInserters.fromValue(wireNotExists))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }
}
