package es.upm.miw.apaw_practice.adapters.rest.school;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.school.Student;
import es.upm.miw.apaw_practice.domain.models.school.Subject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
public class StudentResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateSubjects() {
        List<Subject> subjects = List.of(new Subject("subject5", "desc5", true, 16),
                                         new Subject("subject6", "desc6", false, 1));
        this.webTestClient
                .put()
                .uri(StudentResource.STUDENTS + StudentResource.NAME_ID + StudentResource.SUBJECTS,
                        "student6")
                .body(BodyInserters.fromValue(subjects))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Student.class)
                .value(Assertions::assertNotNull)
                .value(studentData -> {
                    Subject subject1 = studentData.getSubjects().get(0);
                    assertEquals("subject5", subject1.getTitle());
                    assertTrue(subject1.getBilingual());

                    Subject subject2 = studentData.getSubjects().get(1);
                    assertEquals("subject6", subject2.getTitle());
                    assertEquals(1, subject2.getCredits());
                });
    }
}
