package es.upm.miw.apaw_practice.adapters.rest.climbing;

import es.upm.miw.apaw_practice.adapters.mongodb.climbing.ClimbingSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.climbing.Expedition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
class ExpeditionResourceIT {

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private ClimbingSeederService climbingSeederService;

    @AfterEach
    void resetDataBase() {
        this.climbingSeederService.deleteAll();
        this.climbingSeederService.seedDatabase();
    }

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
    void testPatchExpedition() {
        this.webTestClient
                .patch()
                .uri(ExpeditionResource.EXPEDITIONS + ExpeditionResource.IDENTIFIER + "/total-expense", "1")
                .body(BodyInserters.fromValue(new BigDecimal("2000.00")))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Expedition.class)
                .value(Assertions::assertNotNull)
                .value(expedition -> {
                    assertEquals("1", expedition.getIdentifier());
                    assertEquals(LocalDate.now(), expedition.getDate());
                    assertEquals(0, new BigDecimal("2000.00").compareTo(expedition.getTotalExpense()));
                });
    }

    // expeditions/search?q=difficulty:Easy
    @Test
    void testFindSumOfTotalExpenseByRouteDifficulty() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(ExpeditionResource.EXPEDITIONS + ExpeditionResource.SEARCH)
                                .queryParam("q", "difficulty:Easy")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(BigDecimal.class)
                .value(Assertions::assertNotNull)
                .value(sumOfTotalExpense ->
                        assertEquals(0, new BigDecimal("2000.00").compareTo(sumOfTotalExpense))
                );

        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(ExpeditionResource.EXPEDITIONS + ExpeditionResource.SEARCH)
                                .queryParam("q", "difficulty:Hard")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(BigDecimal.class)
                .value(Assertions::assertNotNull)
                .value(sumOfTotalExpense ->
                        assertEquals(0, new BigDecimal("2500.00").compareTo(sumOfTotalExpense))
                );
    }
}
