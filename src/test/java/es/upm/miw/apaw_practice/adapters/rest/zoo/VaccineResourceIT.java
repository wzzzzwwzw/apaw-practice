package es.upm.miw.apaw_practice.adapters.rest.zoo;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.zoo.Vaccine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

import static es.upm.miw.apaw_practice.adapters.rest.zoo.VaccineResource.IDENTIFIER_BATCH;
import static es.upm.miw.apaw_practice.adapters.rest.zoo.VaccineResource.VACCINES;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class VaccineResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testFindByIdentifierBatch() {
        this.webTestClient
                .get()
                .uri(VACCINES + IDENTIFIER_BATCH, "202301A-FLU-FELIS")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Vaccine.class)
                .value(Assertions::assertNotNull)
                .value(vaccine -> {
                    assertEquals("202301A-FLU-FELIS", vaccine.getIdentifierBatch());
                    assertEquals("Felis Flu 2023", vaccine.getName());
                    assertEquals(LocalDate.of(2023, 1, 20), vaccine.getManufacturingDate());
                });

    }
}
