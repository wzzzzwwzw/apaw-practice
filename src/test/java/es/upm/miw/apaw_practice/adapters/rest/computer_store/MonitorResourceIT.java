package es.upm.miw.apaw_practice.adapters.rest.computer_store;

import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.ComputerStoreSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.computer_store.Monitor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
class MonitorResourceIT {
    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private ComputerStoreSeederService computerStoreSeederService;

    @AfterEach
    void resetDataBase() {
        this.computerStoreSeederService.deleteAll();
        this.computerStoreSeederService.seedDatabase();
    }

    @Test
    void testUpdateRefreshRate() {
        this.webTestClient
                .put()
                .uri(MonitorResource.MONITORS + MonitorResource.SERIALNUMBER_ID + MonitorResource.REFRESH_RATE, "XIAOMIC34001")
                .body(BodyInserters.fromValue(240))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Monitor.class)
                .value(Assertions::assertNotNull)
                .value(monitor -> {
                    assertEquals(new BigDecimal("34"), monitor.getSize());
                    assertEquals(240, monitor.getRefreshRate());
                });
    }

    @Test
    void testUpdateRefreshRateMonitorNotFound() {
        this.webTestClient
                .put()
                .uri(MonitorResource.MONITORS + MonitorResource.SERIALNUMBER_ID + MonitorResource.REFRESH_RATE, "HOLA")
                .body(BodyInserters.fromValue(240))
                .exchange()
                .expectStatus().isNotFound();
    }
}
