package es.upm.miw.apaw_practice.adapters.rest.computer_store;

import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.ComputerStoreSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
class ComputerResourceIT {
    private static final String DELETE_BY_REST_COMPUTER = "Delete by rest computer";
    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private ComputerStoreSeederService computerStoreSeederService;

    @BeforeEach
    void cleanUpDb() {
        this.computerStoreSeederService.deleteAll();
        this.computerStoreSeederService.seedDatabase();
    }

    @Test
    void testDeleteEndpoint() {
        this.webTestClient
                .delete()
                .uri(ComputerResource.COMPUTERS + ComputerResource.NAME_ID, DELETE_BY_REST_COMPUTER)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testSearchSumOfComputerCostByJacketMaterial() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(ComputerResource.COMPUTERS + ComputerResource.SEARCH)
                                .queryParam("q", "jacket-material:Plastic")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(BigDecimal.class)
                .value(Assertions::assertNotNull)
                .value(cost -> assertEquals(new BigDecimal("3990"), cost));
    }

    @Test
    void testBadRequestSearchSumOfComputerCostByJacketMaterial() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(ComputerResource.COMPUTERS + ComputerResource.SEARCH)
                                .queryParam("q", "jaket-material:Plastic")
                                .build())
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void testZeroSearchSumOfComputerCostByJacketMaterial() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(ComputerResource.COMPUTERS + ComputerResource.SEARCH)
                                .queryParam("q", "jacket-material:kk")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(BigDecimal.class)
                .value(Assertions::assertNotNull)
                .value(cost -> assertEquals(BigDecimal.ZERO, cost));
    }
}
