package es.upm.miw.apaw_practice.adapters.rest.school;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.adapters.rest.shop.ArticleResource;
import es.upm.miw.apaw_practice.domain.models.school.Classroom;
import es.upm.miw.apaw_practice.domain.models.shop.ArticlePriceUpdating;
import es.upm.miw.apaw_practice.domain.models.shop.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
public class ClassroomResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        Classroom classroom =
                new Classroom("classroomtest", LocalDateTime.of(2000, 1, 1, 1, 1), false, 100);
        this.webTestClient
                .post()
                .uri(ClassroomResource.CLASSROOMS)
                .body(BodyInserters.fromValue(classroom))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Classroom.class)
                .value(Assertions::assertNotNull);
    }

    @Test
    void testCreateConflict() {
        Classroom classroom =
                new Classroom("classroom5", LocalDateTime.of(2023, 9, 1, 8, 00), true, 50);
        this.webTestClient
                .post()
                .uri(ClassroomResource.CLASSROOMS)
                .body(BodyInserters.fromValue(classroom))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }

    @Test
    void testReadByLocation() {
        this.webTestClient
                .get()
                .uri(ClassroomResource.CLASSROOMS + ClassroomResource.LOCATION_ID, "classroom4")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Classroom.class)
                .value(Assertions::assertNotNull)
                .value(classroomData -> {
                    assertEquals("classroom4", classroomData.getLocation());
                    assertEquals(LocalDateTime.of(2022, 2, 8, 7, 15), classroomData.getEntryHour());
                    assertEquals(25, classroomData.getLockers());
                    assertFalse(classroomData.getSmartBoard());
                });
    }

    @Test
    void testReadNotFound() {
        this.webTestClient
                .get()
                .uri(ClassroomResource.CLASSROOMS + ClassroomResource.LOCATION_ID, "foo")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testUpdateLockers() {
        List<Classroom> classrooms = Arrays.asList(
                new Classroom("classroom3", LocalDateTime.of(2000, 1, 1, 1, 1), false, 50),
                new Classroom("classroom4", LocalDateTime.of(2000, 1, 1, 1, 1), false, 80)
        );
        this.webTestClient
                .patch()
                .uri(ClassroomResource.CLASSROOMS)
                .body(BodyInserters.fromValue(classrooms))
                .exchange()
                .expectStatus().isOk();
    }
}
