package es.upm.miw.apaw_practice.domain.models.hospital;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DepartmentIT {
    @Test
    void testDepartmentBuilder() {
        Department department = new Department.Builder()
                .departmentName("TEST111")
                .floor(9)
                .availableBeds(999)
                .build();
        assertNotNull(department);
        assertEquals("TEST111", department.getDepartmentName());
        assertEquals(9, department.getFloor());
        assertEquals(999, department.getAvailableBeds());
    }
}
