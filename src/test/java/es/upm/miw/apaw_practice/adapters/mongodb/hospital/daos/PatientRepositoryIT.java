package es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.hospital.HospitalSeederService;
import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.DoctorEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.PatientEntity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;


import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class PatientRepositoryIT {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private HospitalSeederService hospitalSeederService;

    @AfterEach
    void cleanUpDB() {
        this.hospitalSeederService.deleteAll();
        this.hospitalSeederService.seedDatabase();
    }

    @Test
    void testPatientFindBySocialInsuranceNumber() {
        assertTrue(this.patientRepository.findBySocialInsuranceNumber("111111111").isPresent());
        PatientEntity patient = this.patientRepository.findBySocialInsuranceNumber("111111111").get();
        assertEquals("Male", patient.getGender());
        assertEquals(LocalDate.of(2000,2,2),patient.getBirthDate());
        assertTrue(
                patient.getAppointmentsEntities().stream()
                        .anyMatch(appointment ->
                                appointment.getUrgent().equals(false) &&
                                        appointment.getAppointmentHour().equals(LocalDateTime.of(2023,4,11,11,11)) &&
                                        appointment.getAppointmentRoom().equals("001")
                        )
        );
        assertTrue(patient.getDoctorsEntities().stream()
                .map(DoctorEntity::getMedicalLicenseCode)
                .toList()
                .contains("M001"));
    }

}
