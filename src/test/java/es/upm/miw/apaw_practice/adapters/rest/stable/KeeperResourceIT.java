package es.upm.miw.apaw_practice.adapters.rest.stable;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.stable.Keeper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDate;

@RestTestConfig
public class KeeperResourceIT {
    @Autowired
    private WebTestClient webTestClient;
    @Test
    void testCreate() {
        Keeper keeper =
                new Keeper("Keeper9", 34, LocalDate.of(2019, 10, 10), 29000.0);
        this.webTestClient
                .post()
                .uri(KeeperResource.KEEPERS)
                .body(BodyInserters.fromValue(keeper))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Keeper.class)
                .value(Assertions::assertNotNull);
    }
    @Test
    void testCreateConflict() {
        Keeper keeper =
                new Keeper("Keeper8", 33, LocalDate.of(2018, 9, 9), 28000.0);
        this.webTestClient
                .post()
                .uri(KeeperResource.KEEPERS)
                .body(BodyInserters.fromValue(keeper))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }
}
