package es.upm.miw.apaw_practice.adapters.rest.padel_academy;

import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.PadelAcademySeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.padel_academy.Academy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class AcademyResourceIT {
    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private PadelAcademySeederService padelAcademySeederService;

    @AfterEach
    void resetDatabase() {
        this.padelAcademySeederService.deleteAll();
        this.padelAcademySeederService.seedDatabase();
    }

    @Test
    void testRead() {
        this.webTestClient
                .get()
                .uri(AcademyResource.ACADEMIES + AcademyResource.NAME, "Ocio y Deporte Canal")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Academy.class)
                .value(Assertions::assertNotNull)
                .value(academy -> {
                    assertEquals("Ocio y Deporte Canal", academy.getName());
                    assertEquals("Madrid", academy.getCity());
                    assertEquals("Avda. Filipinas, esq. Pablo Iglesias, 28003", academy.getAddress());
                });
    }

    @Test
    void testReadNotFound() {
        this.webTestClient
                .get()
                .uri(AcademyResource.ACADEMIES + AcademyResource.NAME, "Padel Canal")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(AcademyResource.ACADEMIES + AcademyResource.NAME, "Ocio y Deporte Canal")
                .exchange()
                .expectStatus().isOk();
    }
}
