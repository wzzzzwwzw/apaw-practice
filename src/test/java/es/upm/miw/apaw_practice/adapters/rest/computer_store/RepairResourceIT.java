package es.upm.miw.apaw_practice.adapters.rest.computer_store;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.computer_store.Repair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
class RepairResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testPatchEndpoint() {
        this.webTestClient
                .patch()
                .uri(RepairResource.REPAIRS + RepairResource.REPAIR_NUMBER_ID, "1234")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Repair.class)
                .value(Assertions::assertNotNull)
                .value(repair -> {
                    assertEquals("1234", repair.getRepairNumber());
                    assertTrue(repair.getBeginTime().toLocalDate().atStartOfDay().isEqual(LocalDate.now().atStartOfDay()));
                    assertTrue(repair.getEndTime().toLocalDate().atStartOfDay().isEqual(LocalDate.now().atStartOfDay()));
                });
    }
}
