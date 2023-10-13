package es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities;

import es.upm.miw.apaw_practice.domain.models.hospital.Department;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class DepartmentEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String departmentName;
    private Integer availableBeds;
    private Integer floor;

    public DepartmentEntity() {
        //empty for framework
    }

    public DepartmentEntity(String departmentName, Integer availableBeds, Integer floor) {
        this.id = UUID.randomUUID().toString();
        this.departmentName = departmentName;
        this.availableBeds = availableBeds;
        this.floor=floor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getAvailableBeds() {
        return availableBeds;
    }

    public void setAvailableBeds(Integer availableBeds) {
        this.availableBeds = availableBeds;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Department toDepartment() {
        Department department = new Department();
        BeanUtils.copyProperties(this, department);
        return department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentEntity that = (DepartmentEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(departmentName, that.departmentName) && Objects.equals(availableBeds, that.availableBeds) && Objects.equals(floor, that.floor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentName, availableBeds, floor);
    }

    @Override
    public String toString() {
        return "DepartmentEntity{" +
                "id='" + id + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", occupiedBeds=" + availableBeds +
                ", floor=" + floor +
                '}';
    }
}
