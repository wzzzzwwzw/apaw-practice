package es.upm.miw.apaw_practice.adapters.rest.school;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.school.Subject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
public class SubjectResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        Subject subject =
                new Subject("subjectTest", "descriptiontest", true, 50);
        this.webTestClient
                .post()
                .uri(SubjectResource.SUBJECTS)
                .body(BodyInserters.fromValue(subject))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Subject.class)
                .value(Assertions::assertNotNull);
    }

    @Test
    void testCreateConflict() {
        Subject subject =
                new Subject("subject5", "foo", true, 50);
        this.webTestClient
                .post()
                .uri(SubjectResource.SUBJECTS)
                .body(BodyInserters.fromValue(subject))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }

    @Test
    void testReadByTitle() {
        this.webTestClient
                .get()
                .uri(SubjectResource.SUBJECTS + SubjectResource.TITLE_ID, "subject4")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Subject.class)
                .value(Assertions::assertNotNull)
                .value(subjectData -> {
                    assertEquals("subject4", subjectData.getTitle());
                    assertEquals(1, subjectData.getCredits());
                    assertFalse(subjectData.getBilingual());
                });
    }

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(SubjectResource.SUBJECTS + SubjectResource.TITLE_ID, "subjectResource")
                .exchange()
                .expectStatus().isOk();
    }
}
