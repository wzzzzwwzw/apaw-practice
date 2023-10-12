package es.upm.miw.apaw_practice.domain.models.hospital;

public class Department {
    private String departmentName;
    private Integer occupiedBeds;
    private Integer floor;

    public Department() {
        //empty for framework
    }

    public Department(String departmentName, Integer occupiedBeds, Integer floor) {
        this.departmentName = departmentName;
        this.occupiedBeds = occupiedBeds;
        this.floor=floor;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getOccupiedBeds() {
        return occupiedBeds;
    }

    public void setOccupiedBeds(Integer occupiedBeds) {
        this.occupiedBeds = occupiedBeds;
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
                ", occupiedBeds='" + occupiedBeds + '\'' +
                ", floor='" + floor + '\'' +
                '}';
    }
}
