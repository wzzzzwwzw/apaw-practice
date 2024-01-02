package es.upm.miw.apaw_practice.adapters.mongodb.hospital.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.hospital.Department;
import es.upm.miw.apaw_practice.domain.models.hospital.Doctor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class DoctorPersistenceMongodbIT {
    @Autowired
    private DoctorPersistenceMongodb doctorPersistence;

    @Test
    void testReadNotFound() {
        assertThrows(NotFoundException.class, () -> this.doctorPersistence.read(".."));
    }

    @Test
    void testReadFound() {
        assertNotNull(this.doctorPersistence.read("M004"));
    }

    @Test
    void testCreateDoctor() {
        Department department = new Department("TestDepartment",20,6);
        Doctor doctor = this.doctorPersistence.create(new Doctor("M006", "E04", department));
        Doctor createDoctor = this.doctorPersistence.create(doctor);
        assertNotNull(createDoctor);
        assertEquals(doctor.getMedicalLicenseCode(), createDoctor.getMedicalLicenseCode());
        assertEquals(doctor.getSpeciality(), createDoctor.getSpeciality());
        assertEquals(doctor.getDepartment().getDepartmentName(),createDoctor.getDepartment().getDepartmentName());
    }

    @Test
    void testExistDoctorName() {
        assertTrue(this.doctorPersistence.existsDoctor("M001"));
    }

    @Test
    void testNotExistDoctorName() {
        assertFalse(this.doctorPersistence.existsDoctor("Error"));
    }


}

