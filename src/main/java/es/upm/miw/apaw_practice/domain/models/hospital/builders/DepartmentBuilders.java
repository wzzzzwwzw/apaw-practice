package es.upm.miw.apaw_practice.domain.models.hospital.builders;

import es.upm.miw.apaw_practice.domain.models.hospital.Department;

public interface DepartmentBuilders {
    interface DepartmentName {
        Optionals departmentName(String departmentName);
    }
    interface Optionals {
        Optionals availableBeds(Integer availableBeds);
        Optionals floor(Integer floor);
        Department build();
    }
}
