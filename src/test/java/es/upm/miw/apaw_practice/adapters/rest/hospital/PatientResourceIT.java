package es.upm.miw.apaw_practice.adapters.rest.hospital;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.hospital.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
class PatientResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testGetByName() {
        this.webTestClient
                .get()
                .uri(PatientResource.PATIENTS + PatientResource.SOCIAL_INSURANCE_NUMBER, "000000000")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Patient.class)
                .value(Assertions::assertNotNull)
                .value(patient -> {
                    assertEquals("000000000", patient.getSocialInsuranceNumber());
                    assertEquals("Female", patient.getGender());
                    assertEquals(2, patient.getDoctors().size());
                    assertEquals(Boolean.TRUE, patient.getAppointments().get(0).getUrgent());
                    assertEquals("101", patient.getAppointments().get(1).getAppointmentRoom());
                    assertEquals(LocalDate.of(1999,1,1), patient.getBirthDate());
                });
    }

}
