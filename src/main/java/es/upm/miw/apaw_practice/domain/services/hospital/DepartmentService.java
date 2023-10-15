package es.upm.miw.apaw_practice.domain.services.hospital;

import es.upm.miw.apaw_practice.domain.models.hospital.Department;
import es.upm.miw.apaw_practice.domain.persistence_ports.hospital.DepartmentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private final DepartmentPersistence departmentPersistence;

    @Autowired
    public DepartmentService(DepartmentPersistence departmentPersistence) {
        this.departmentPersistence = departmentPersistence;
    }

    public Department updateAvailableBeds(String departmentName, Integer availableBeds) {
        Department department = this.departmentPersistence.readByDepartmentName(departmentName);
        department.setAvailableBeds(availableBeds);
        return this.departmentPersistence.updateAvailableBeds(department);
    }
}
