package es.upm.miw.apaw_practice.adapters.rest.padel_academy;

import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.PadelAcademySeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
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
                .uri(InstructorResource.INSTRUCTORS+InstructorResource.DNI,"13579086B")
                .body(BodyInserters.fromValue(123456789))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testFindInstructorsNamesByCourtSurface() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(InstructorResource.INSTRUCTORS + InstructorResource.SEARCH)
                                .queryParam("q", "surface:clay")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .value(names -> {
                    assertFalse(names.isEmpty());
                    names.forEach(name -> {
                        assertTrue(name.contains("Ana") && name.contains("Luis"));
                    });
                });
    }

}
