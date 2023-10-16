package es.upm.miw.apaw_practice.adapters.mongodb.hospital.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.hospital.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class DepartmentPersistenceMongodbIT {
    @Autowired
    private DepartmentPersistenceMongodb departmentPersistenceMongodb;

    @Test
    void testReadByDepartmentNameNotFound() {
        assertThrows(NotFoundException.class, () -> this.departmentPersistenceMongodb.readByDepartmentName("DepartmentNotExists"));
    }

    @Test
    void testUpdateAvailableBeds() {
        Department department = this.departmentPersistenceMongodb.readByDepartmentName("Rehabilitation");
        department.setAvailableBeds(999);
        this.departmentPersistenceMongodb.updateAvailableBeds(department);
        department = this.departmentPersistenceMongodb.readByDepartmentName("Rehabilitation");
        assertEquals(999, department.getAvailableBeds());
    }

    @Test
    void testUpdateAvailableBedsNotFound() {
        Department department = new Department("DepartmentNotExists1",999,999);
        assertThrows(NotFoundException.class, () -> this.departmentPersistenceMongodb.updateAvailableBeds(department));
    }

}

