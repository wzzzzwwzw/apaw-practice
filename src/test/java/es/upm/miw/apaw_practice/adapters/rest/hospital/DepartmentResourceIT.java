package es.upm.miw.apaw_practice.adapters.rest.hospital;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.hospital.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;
@RestTestConfig
public class DepartmentResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateAvailableBeds() {
        this.webTestClient
                .put()
                .uri(DepartmentResource.DEPARTMENTS + DepartmentResource.NAME + DepartmentResource.AVAILABLE_BEDS, "Surgery")
                .body(BodyInserters.fromValue(111))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Department.class)
                .value(Assertions::assertNotNull)
                .value(department -> {
                    assertEquals(2, department.getFloor());
                    assertEquals(111, department.getAvailableBeds());
                });
    }

    @Test
    void testUpdateAvailableBedsDepartmentNotFound() {
        this.webTestClient
                .put()
                .uri(DepartmentResource.DEPARTMENTS + DepartmentResource.NAME + DepartmentResource.AVAILABLE_BEDS, "DepartmentNotExits")
                .body(BodyInserters.fromValue(240))
                .exchange()
                .expectStatus().isNotFound();
    }

}
