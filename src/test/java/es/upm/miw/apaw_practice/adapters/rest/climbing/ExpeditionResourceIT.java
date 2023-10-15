package es.upm.miw.apaw_practice.adapters.rest.climbing;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.climbing.Expedition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@RestTestConfig
public class ExpeditionResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testPostExpedition() {
        Expedition newExpedition = new Expedition(LocalDate.of(2023, 10, 15), new BigDecimal("1500.00"));
        this.webTestClient
                .post()
                .uri(ExpeditionResource.EXPEDITIONS)
                .body(BodyInserters.fromValue(newExpedition))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Expedition.class)
                .value(Assertions::assertNotNull)
                .value(expedition -> {
                    assertEquals(newExpedition.getDate(), expedition.getDate());
                    assertEquals(newExpedition.getTotalExpense(), expedition.getTotalExpense());
                });
    }

    @Test
    void testPostDefaultTotalExpense() {
        Expedition newExpedition = new Expedition(LocalDate.of(2023, 10, 15), null);
        this.webTestClient
                .post()
                .uri(ExpeditionResource.EXPEDITIONS)
                .body(BodyInserters.fromValue(newExpedition))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Expedition.class)
                .value(Assertions::assertNotNull)
                .value(expedition -> {
                    assertEquals(newExpedition.getDate(), expedition.getDate());
                    assertEquals(BigDecimal.ZERO, expedition.getTotalExpense());
                });
    }
}
