package es.upm.miw.apaw_practice.domain.models.formula_one;

import es.upm.miw.apaw_practice.domain.models.formula_one.builders.DriverBuilders;

public class Driver {

    private Integer number;
    private String driverName;
    private String nationality;
    private Float points;

    public Driver() {
        //empty for framework
    }

    public Driver(Integer number, String driverName, String nationality) {
        this.number = number;
        this.driverName = driverName;
        this.nationality = nationality;
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
                ", points=" + points +
                '}';
    }

    public static class Builder implements DriverBuilders.Number, DriverBuilders.DriverName,
            DriverBuilders.Nationality, DriverBuilders.Optionals {

        private final Driver driver;

        public Builder() {
            this.driver = new Driver();
        }

        @Override
        public DriverBuilders.DriverName number(Integer number) {
            this.driver.number = number;
            return this;
        }

        @Override
        public DriverBuilders.Nationality driverName(String driverName) {
            this.driver.driverName = driverName;
            return this;
        }

        @Override
        public DriverBuilders.Optionals nationality(String nationality) {
            this.driver.nationality = nationality;
            return this;
        }

        @Override
        public DriverBuilders.Optionals points(Float points) {
            this.driver.points = points;
            return this;
        }

        @Override
        public Driver build() {
            return this.driver;
        }
    }
}
