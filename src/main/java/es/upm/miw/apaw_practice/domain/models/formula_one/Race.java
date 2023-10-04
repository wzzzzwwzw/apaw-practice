package es.upm.miw.apaw_practice.domain.models.formula_one;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Race {

    private String circuitName;
    private String hostCountry;
    private LocalDate date;
    private List<Driver> drivers;
    private Integer laps;
    private Boolean nightRace;

    public Race() {
        //empty for framework
    }

    public Race(String circuitName, String hostCountry, LocalDate date, List<Driver> drivers) {
        this.circuitName = circuitName;
        this.hostCountry = hostCountry;
        this.date = date;
        this.drivers = drivers;
    }

    public String getCircuitName() {
        return circuitName;
    }

    public void setCircuitName(String circuitName) {
        this.circuitName = circuitName;
    }

    public String getHostCountry() {
        return hostCountry;
    }

    public void setHostCountry(String hostCountry) {
        this.hostCountry = hostCountry;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public Integer getLaps() {
        return laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
    }

    public Boolean isNightRace() {
        return nightRace;
    }

    public void setNightRace(Boolean nightRace) {
        this.nightRace = nightRace;
    }

    @Override
    public String toString() {
        return "Race{" +
                "circuitName='" + circuitName + '\'' +
                ", hostCountry='" + hostCountry + '\'' +
                ", date=" + date +
                ", drivers=" + drivers +
                ", laps=" + laps +
                ", nightRace=" + nightRace +
                '}';
    }
}
