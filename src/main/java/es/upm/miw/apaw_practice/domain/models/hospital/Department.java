package es.upm.miw.apaw_practice.domain.models.hospital;

import es.upm.miw.apaw_practice.domain.models.computer_store.Monitor;
import es.upm.miw.apaw_practice.domain.models.computer_store.Wire;
import es.upm.miw.apaw_practice.domain.models.computer_store.builders.MonitorBuilders;
import es.upm.miw.apaw_practice.domain.models.hospital.builders.DepartmentBuilders;

import java.math.BigDecimal;
import java.util.List;

public class Department {
    private String departmentName;
    private Integer availableBeds;
    private Integer floor;

    public Department() {
        //empty for framework
    }

    public Department(String departmentName, Integer availableBeds, Integer floor) {
        this.departmentName = departmentName;
        this.availableBeds = availableBeds;
        this.floor=floor;
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

    @Override
    public String toString() {
        return "Department{" +
                "departmentName=" + departmentName +
                ", availableBeds='" + availableBeds + '\'' +
                ", floor='" + floor + '\'' +
                '}';
    }

    public static class Builder implements DepartmentBuilders.DepartmentName, DepartmentBuilders.Optionals {
        private final Department department;

        public Builder() {
            department = new Department();
        }

        @Override
        public DepartmentBuilders.Optionals departmentName(String departmentName) {
            this.department.departmentName = departmentName;
            return this;
        }

        @Override
        public DepartmentBuilders.Optionals availableBeds(Integer availableBeds) {
            this.department.availableBeds = availableBeds;
            return this;
        }

        @Override
        public DepartmentBuilders.Optionals floor(Integer floor) {
            this.department.floor = floor;
            return this;
        }

        @Override
        public Department build() {
            return this.department;
        }
    }

}
