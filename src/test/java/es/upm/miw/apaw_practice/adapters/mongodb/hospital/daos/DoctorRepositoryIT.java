package es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.hospital.HospitalSeederService;
import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.DoctorEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class DoctorRepositoryIT {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private HospitalSeederService hospitalSeederService;

    @AfterEach
    void cleanUpDB() {
        this.hospitalSeederService.deleteAll();
        this.hospitalSeederService.seedDatabase();
    }

    @Test
    void testDoctorFindByMedicalLicenseCode() {
        assertTrue(this.doctorRepository.findByMedicalLicenseCode("M003").isPresent());
        DoctorEntity doctor = this.doctorRepository.findByMedicalLicenseCode("M003").get();
        assertEquals("P01", doctor.getOffice());
        assertEquals("Pediatrics", doctor.getDepartmentEntity().getDepartmentName());
        assertEquals(7, doctor.getDepartmentEntity().getAvailableBeds());
        assertEquals(1, doctor.getDepartmentEntity().getFloor());
    }

}
