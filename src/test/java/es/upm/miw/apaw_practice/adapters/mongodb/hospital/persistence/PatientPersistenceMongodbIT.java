package es.upm.miw.apaw_practice.adapters.mongodb.hospital.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.computer_store.Repair;
import es.upm.miw.apaw_practice.domain.models.hospital.Appointment;
import es.upm.miw.apaw_practice.domain.models.hospital.Department;
import es.upm.miw.apaw_practice.domain.models.hospital.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class PatientPersistenceMongodbIT {
    @Autowired
    private PatientPersistenceMongodb patientPersistence;

    @Test
    void testReadNotFound() {
        assertThrows(NotFoundException.class, () -> this.patientPersistence.read(".."));
    }

    @Test
    void testReadFound() {
        assertNotNull(this.patientPersistence.read("000000000"));
    }

    @Test
    void testUpdateAllergicMedicine() {
        Patient patient = this.patientPersistence.updateAllergicMedicine("222222222","Test");
        assertNotNull(patient);
        assertEquals("222222222", patient.getSocialInsuranceNumber());
        assertEquals("Test", patient.getAllergicMedicine());
    }

    @Test
    void testUpdateAllergicMedicineTimeException() {
        assertThrows(NotFoundException.class, () -> this.patientPersistence.updateAllergicMedicine("test","test"));
    }
}

