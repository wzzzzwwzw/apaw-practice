package es.upm.miw.apaw_practice.domain.persistence_ports.hospital;

import es.upm.miw.apaw_practice.domain.models.hospital.Department;

public interface DepartmentPersistence {

    Department updateAvailableBeds(Department department);

    Department readByDepartmentName(String departmentName);
}
