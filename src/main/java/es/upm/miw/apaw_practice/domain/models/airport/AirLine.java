package es.upm.miw.apaw_practice.domain.models.airport;

import es.upm.miw.apaw_practice.domain.models.airport.builders.AirLineBuilders;

import java.time.LocalDate;
import java.util.List;

public class AirLine {
    private String name;
    private LocalDate dayOfFoundation;
    private List<Aircraft> aircrafts;

    public AirLine(){
        //empty for framework
    }

    public AirLine(String name, LocalDate dayOfFoundation, List<Aircraft> aircrafts) {
        this.name = name;
        this.dayOfFoundation = dayOfFoundation;
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
    public static class Builder implements AirLineBuilders.Name, AirLineBuilders.DayOfFoundation, AirLineBuilders.Aircrafts, AirLineBuilders.Build{

        private final AirLine airLine;

        public Builder(){
            this.airLine = new AirLine();
        }

        @Override
        public AirLineBuilders.DayOfFoundation name(String name) {
            this.airLine.name = name;
            return this;
        }

        @Override
        public AirLineBuilders.Aircrafts dayOfFoundation(LocalDate dayOfFoundations) {
            this.airLine.dayOfFoundation = dayOfFoundations;
            return this;
        }

        @Override
        public AirLineBuilders.Build aricrafts(List<Aircraft> aircrafts) {
            this.airLine.aircrafts = aircrafts;
            return this;
        }

        @Override
        public AirLine build() {
            return this.airLine;
        }
    }
}

