package es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.HospitalSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.DepartmentEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class DepartmentRepositoryIT {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private HospitalSeederService hospitalSeederService;

    @AfterEach
    void cleanUpDB() {
        this.hospitalSeederService.deleteAll();
        this.hospitalSeederService.seedDatabase();
    }

    @Test
    void testDepartmentFindByName() {
        assertTrue(this.departmentRepository.findByDepartmentName("Emergency").isPresent());
        DepartmentEntity department = this.departmentRepository.findByDepartmentName("Emergency").get();
        assertEquals(10, department.getAvailableBeds());
        assertEquals(0, department.getFloor());
    }

}
