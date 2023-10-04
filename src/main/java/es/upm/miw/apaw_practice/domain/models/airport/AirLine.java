package es.upm.miw.apaw_practice.domain.models.airport;

import java.time.LocalDate;
import java.util.List;

public class AirLine {
    private String name;
    private LocalDate dayOfFoundation;
    private List<Aircraft> aircrafts;

    public AirLine(){
        //empty for framework
    }

    public AirLine(String name, LocalDate dayOfFundation, List<Aircraft> aircrafts) {
        this.name = name;
        this.dayOfFoundation = dayOfFundation;
        this.aircrafts = aircrafts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDayOfFoundation() {
        return dayOfFoundation;
    }

    public void setDayOfFoundation(LocalDate dayOfFoundation) {
        this.dayOfFoundation = dayOfFoundation;
    }

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public void setAircrafts(List<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }

    @Override
    public String toString() {
        return "AirLine{" +
                "name='" + name + '\'' +
                ", dayOfFundation=" + dayOfFoundation +
                ", aircrafts=" + aircrafts +
                '}';
    }
}
