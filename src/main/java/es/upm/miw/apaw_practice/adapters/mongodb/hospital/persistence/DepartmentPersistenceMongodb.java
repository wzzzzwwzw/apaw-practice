package es.upm.miw.apaw_practice.adapters.mongodb.hospital.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos.DepartmentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.DepartmentEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.hospital.Department;
import es.upm.miw.apaw_practice.domain.persistence_ports.hospital.DepartmentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("departmentPersistence")
public class DepartmentPersistenceMongodb implements DepartmentPersistence {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentPersistenceMongodb(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    @Override
    public Department updateAvailableBeds(Department department) {
        DepartmentEntity departmentEntity = this.departmentRepository
                .findByDepartmentName(department.getDepartmentName())
                .orElseThrow(() -> new NotFoundException("Department name: " + department.getDepartmentName()));
        departmentEntity.setAvailableBeds(department.getAvailableBeds());
        return this.departmentRepository.save(departmentEntity).toDepartment();
    }

    @Override
    public Department readByDepartmentName(String departmentName) {
        return this.departmentRepository
                .findByDepartmentName(departmentName)
                .orElseThrow(() -> new NotFoundException("Monitor serial number: " + departmentName))
                .toDepartment();
    }
}
