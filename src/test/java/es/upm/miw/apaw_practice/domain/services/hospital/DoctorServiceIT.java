package es.upm.miw.apaw_practice.domain.services.hospital;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.hospital.Department;
import es.upm.miw.apaw_practice.domain.models.hospital.Doctor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
@TestConfig
public class DoctorServiceIT {
    @Autowired
    private DoctorService doctorService;

    @Test
    void testCreateDoctor() {
        Department department = new Department("TestDep",10,10);
        Doctor doctor = this.doctorService.create(new Doctor("M011", "T01",department));
        assertEquals("M011", doctor.getMedicalLicenseCode());
        assertEquals("T01",doctor.getSpeciality());
        assertEquals(10, doctor.getDepartment().getAvailableBeds());

    }

    @Test
    void testExistDoctor(){
        Department department = new Department("Emergency",10,0);
        Doctor doctor = new Doctor("M001", "E01",department);
        RuntimeException exception = assertThrows(ConflictException.class, () -> {
            this.doctorService.create(doctor);
        });
        assertFalse(exception.getMessage().contains("Doctor exist: M001"));
    }
}
