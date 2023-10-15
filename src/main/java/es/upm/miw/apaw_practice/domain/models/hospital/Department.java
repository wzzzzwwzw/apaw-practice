package es.upm.miw.apaw_practice.domain.models.hospital;

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
}
