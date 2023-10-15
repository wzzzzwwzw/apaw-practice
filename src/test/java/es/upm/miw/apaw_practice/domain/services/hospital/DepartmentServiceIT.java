package es.upm.miw.apaw_practice.domain.services.hospital;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.hospital.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.jupiter.api.Assertions.assertEquals;
@TestConfig
public class DepartmentServiceIT {
    @Autowired
    private DepartmentService departmentService;
    @Test
    void testUpdateRefreshRate() {
        Department department = this.departmentService.updateAvailableBeds("Radiology",333);
        assertEquals(333, department.getAvailableBeds());
        assertEquals(3, department.getFloor());
        this.departmentService.updateAvailableBeds("Radiology", 165);
    }

}
