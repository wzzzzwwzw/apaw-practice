package es.upm.miw.apaw_practice.adapters.rest.swimming;

import es.upm.miw.apaw_practice.adapters.mongodb.swimming.SwimmingSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.swimming.Tutor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static es.upm.miw.apaw_practice.adapters.rest.swimming.TutorResource.TUTORS;
import static es.upm.miw.apaw_practice.adapters.rest.swimming.TutorResource.APPELLATION_ID;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class TutorResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private SwimmingSeederService swimmingSeederService;

    @AfterEach
    void resetDB() {
        this.swimmingSeederService.deleteAll();
        this.swimmingSeederService.seedDatabase();
    }

    @Test
    void testRead() {
        this.webTestClient
                .get()
                .uri(TUTORS + APPELLATION_ID, "Miguel Martinez")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Tutor.class)
                .value(Assertions::assertNotNull)
                .value(tutorData -> {
                    assertEquals("Miguel Martinez", tutorData.getAppellation());
                    assertEquals("Armful", tutorData.getSpecialty());
                    assertEquals(5, tutorData.getExperience());
                });
    }

    @Test
    void testReadNotFound() {
        this.webTestClient
                .get()
                .uri(TUTORS + APPELLATION_ID, "Jose David")
                .exchange()
                .expectStatus().isNotFound();
    }
}
