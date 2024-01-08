package es.upm.miw.apaw_practice.adapters.rest.padel_academy;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.PadelAcademySeederService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@TestConfig
public class InstructorResourceIT {
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
    void testUpdate(){
        this.webTestClient
                .patch()
                .uri(InstructorResource.INSTRUCTORS+InstructorResource.DNI,"12345678A")
                .body(BodyInserters.fromValue(123456789))
                .exchange()
                .expectStatus().isOk();
    }
}
