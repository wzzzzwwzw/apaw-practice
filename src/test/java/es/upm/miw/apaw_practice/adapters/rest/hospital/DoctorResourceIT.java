package es.upm.miw.apaw_practice.adapters.rest.hospital;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.hospital.Department;
import es.upm.miw.apaw_practice.domain.models.hospital.Doctor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
class DoctorResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testPostDoctor() {
        Department departmentNotExists = new Department("notExistsDepartment",200, 1);
        Doctor doctorNotExists = new Doctor("M010","M01" , departmentNotExists);
        this.webTestClient
                .post()
                .uri(DoctorResource.DOCTORS)
                .body(BodyInserters.fromValue(doctorNotExists))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Doctor.class)
                .value(Assertions::assertNotNull);
    }

    @Test
    void testPostAlreadyExistDoctor() {
        Department department = new Department("Emergency", 10 , 0);
        Doctor doctor = new Doctor("M001","E01",department );
        this.webTestClient
                .post()
                .uri(DoctorResource.DOCTORS)
                .body(BodyInserters.fromValue(doctor))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }


}
