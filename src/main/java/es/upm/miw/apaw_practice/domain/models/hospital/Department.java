package es.upm.miw.apaw_practice.domain.models.hospital;

public class Department {
    private String departmentName;
    private int occupiedBeds;
    private int floor;

    public Department() {
        //empty for framework
    }

    public Department(String departmentName, int occupiedBeds, int floor) {
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

    public int getOccupiedBeds() {
        return occupiedBeds;
    }

    public void setOccupiedBeds(int occupiedBeds) {
        this.occupiedBeds = occupiedBeds;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
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
