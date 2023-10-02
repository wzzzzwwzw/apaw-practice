package es.upm.miw.apaw_practice.domain.models.formula_one;

public class Driver {

    private Integer number;
    private String driverName;
    private String nationality;
    private DrivingStyle drivingStyle;
    private Float points;

    public Driver() {
        //empty for framework
    }

    public Driver(Integer number, String driverName, String nationality) {
        this.number = number;
        this.driverName = driverName;
        this.nationality = nationality;
        this.drivingStyle = new DrivingStyle();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public DrivingStyle getDrivingStyle() {
        return drivingStyle;
    }

    public void setDrivingStyle(DrivingStyle drivingStyle) {
        this.drivingStyle = drivingStyle;
    }

    public Float getPoints() {
        return points;
    }

    public void setPoints(Float points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "number=" + number +
                ", driverName='" + driverName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", drivingStyle=" + drivingStyle +
                ", points=" + points +
                '}';
    }
}
