package es.upm.miw.apaw_practice.domain.models.formula_one;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String teamName;
    private String country;
    private List<Driver> drivers;
    private String mainColor;

    public Team() {
        this.drivers = new ArrayList<>();
    }

    public Team(String teamName, String country) {
        this();
        this.teamName = teamName;
        this.country = country;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public String getMainColor() {
        return mainColor;
    }

    public void setMainColor(String mainColor) {
        this.mainColor = mainColor;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", country='" + country + '\'' +
                ", drivers=" + drivers +
                ", mainColor='" + mainColor + '\'' +
                '}';
    }
}
