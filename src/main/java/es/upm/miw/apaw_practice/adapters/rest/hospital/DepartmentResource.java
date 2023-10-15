package es.upm.miw.apaw_practice.adapters.rest.hospital;

import es.upm.miw.apaw_practice.domain.models.hospital.Department;
import es.upm.miw.apaw_practice.domain.services.hospital.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(DepartmentResource.DEPARTMENTS)
public class DepartmentResource {
    static final String DEPARTMENTS = "/hospital/departments";
    static final String AVAILABLE_BEDS = "/available_beds";
    static final String DEPARTMENT_NAME = "/{department_name}";
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentResource(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PutMapping(DEPARTMENT_NAME + AVAILABLE_BEDS)
    public Department updateDepartmentAvailableBeds(@PathVariable String departmentName, @RequestBody Integer availableBeds) {
        return this.departmentService.updateAvailableBeds(departmentName, availableBeds);
    }


}
