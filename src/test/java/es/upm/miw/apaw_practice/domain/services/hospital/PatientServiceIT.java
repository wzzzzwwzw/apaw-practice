package es.upm.miw.apaw_practice.domain.services.hospital;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.hospital.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@TestConfig
class PatientServiceIT {
    @Autowired
    private PatientService patientService;

    @Test
    void testReadService(){
        Patient patient = patientService.read("333333333");
        assertNotNull(patient);
        assertEquals("NONE",patient.getAllergicMedicine());
        assertEquals(LocalDate.of(1987,5,11),patient.getBirthDate());
        assertEquals(2,patient.getDoctors().size());
        assertEquals(LocalDateTime.of(2023,11,11,10,30),patient.getAppointments().get(0).getAppointmentHour());
        assertEquals(Boolean.FALSE,patient.getAppointments().get(1).getUrgent());
        assertEquals(Boolean.TRUE,patient.getAppointments().get(0).getUrgent());
    }

}