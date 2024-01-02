package es.upm.miw.apaw_practice.domain.models.formula_one;

import es.upm.miw.apaw_practice.domain.models.formula_one.builders.RaceBuilders;

import java.time.LocalDate;
import java.util.List;

public class Race {

    private String circuitName;
    private String hostCountry;
    private LocalDate date;
    private List<Driver> raceDrivers;
    private Integer laps;
    private Boolean nightRace;

    public Race() {
        //empty for framework
    }

    public Race(String circuitName, String hostCountry, LocalDate date, List<Driver> raceDrivers) {
        this.circuitName = circuitName;
        this.hostCountry = hostCountry;
        this.date = date;
        this.raceDrivers = raceDrivers;
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

    public List<Driver> getRaceDrivers() {
        return raceDrivers;
    }

    public void setRaceDrivers(List<Driver> raceDrivers) {
        this.raceDrivers = raceDrivers;
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
                ", raceDrivers=" + raceDrivers +
                ", laps=" + laps +
                ", nightRace=" + nightRace +
                '}';
    }

    public static class Builder implements RaceBuilders.CircuitName, RaceBuilders.HostCountry, RaceBuilders.Optionals {

        private final Race race;

        public Builder() {
            this.race = new Race();
        }

        @Override
        public RaceBuilders.HostCountry circuitName(String circuitName) {
            this.race.circuitName = circuitName;
            return this;
        }

        @Override
        public RaceBuilders.Optionals hostCountry(String hostCountry) {
            this.race.hostCountry = hostCountry;
            return this;
        }

        @Override
        public RaceBuilders.Optionals date(LocalDate date) {
            this.race.date = date;
            return this;
        }

        @Override
        public RaceBuilders.Optionals raceDrivers(List<Driver> raceDrivers) {
            this.race.raceDrivers = raceDrivers;
            return this;
        }

        @Override
        public RaceBuilders.Optionals laps(Integer laps) {
            this.race.laps = laps;
            return this;
        }

        @Override
        public RaceBuilders.Optionals nightRace(Boolean nightRace) {
            this.race.nightRace = nightRace;
            return this;
        }

        @Override
        public Race build() {
            return this.race;
        }
    }
}
