package es.upm.miw.apaw_practice.adapters.rest.computer_store;

import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.ComputerStoreSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.adapters.rest.computer_store.dtos.SerialNumberCollectionDTO;
import es.upm.miw.apaw_practice.domain.models.computer_store.Monitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
class MonitorResourceIT {
    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private ComputerStoreSeederService computerStoreSeederService;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH mm ss");

    @BeforeEach
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

    @Test
    void testSearchSerialNumberByDateAndCost() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(MonitorResource.MONITORS + MonitorResource.SEARCH)
                                .queryParam("q", "date:" + this.dateTimeFormatter.format(LocalDateTime.now().plusHours(1)) + ";cost:1.00")
                                .build()
                )
                .exchange()
                .expectStatus().isOk()
                .expectBody(SerialNumberCollectionDTO.class)
                .value(Assertions::assertNotNull)
                .value(serialNumberCollectionDTO -> {
                    assertNotNull(serialNumberCollectionDTO.getSerialNumbers());
                    assertEquals(2, serialNumberCollectionDTO.getSerialNumbers().size());
                });
    }

    @Test
    void testBadRequestExceptionSearchSerialNumberByDateAndCost() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(MonitorResource.MONITORS + MonitorResource.SEARCH)
                                .queryParam("q", "date:" + this.dateTimeFormatter.format(LocalDateTime.now()) + ";cost:-1.00")
                                .build()
                )
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void testNotFoundExceptionSearchSerialNumberByDateAndCost() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(MonitorResource.MONITORS + MonitorResource.SEARCH)
                                .queryParam("q", "date:" + this.dateTimeFormatter.format(LocalDateTime.now().minusDays(3)) + ";cost:1.00")
                                .build()
                )
                .exchange()
                .expectStatus().isNotFound();
    }
}
