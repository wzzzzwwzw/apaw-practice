package es.upm.miw.apaw_practice.domain.models.airport;

import es.upm.miw.apaw_practice.domain.models.airport.builders.AircraftBuilders;

import java.time.LocalDate;

public class Aircraft {

    private LocalDate dateOfLastRevision;
    private Integer capacity;
    private String model;
    private String numberPlate;

    public Aircraft(){
        //empty for framework
    }
    public Aircraft(LocalDate dateOfLastRevision, Integer capacity, String model, String numberPlate) {
        this.dateOfLastRevision = dateOfLastRevision;
        this.capacity = capacity;
        this.model = model;
    }

    public static AircraftBuilders.DateOfLastRevision builder(){
        return new Builder();
    }
    public LocalDate getDateOfLastRevision() {
        return dateOfLastRevision;
    }

    public void setDateOfLastRevision(LocalDate dateOfLastRevision) {
        this.dateOfLastRevision = dateOfLastRevision;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }
    @Override
    public String toString() {
        return "Aircraft{" +
                "dateOfLastRevision=" + dateOfLastRevision +
                ", capacity=" + capacity +
                ", model='" + model + '\'' +
                ", numberPlate='" + numberPlate + '\'' +
                '}';
    }
    public static class Builder implements AircraftBuilders.DateOfLastRevision, AircraftBuilders.Capacity, AircraftBuilders.Model, AircraftBuilders.NumberPlate, AircraftBuilders.Build{

        private final Aircraft aircraft;
        public Builder(){
            this.aircraft = new Aircraft();
        }
        @Override
        public AircraftBuilders.Capacity dateOfLastRevision(LocalDate dateOfLastRevision) {
            this.aircraft.dateOfLastRevision = dateOfLastRevision;
            return this;
        }

        @Override
        public AircraftBuilders.Model capacity(Integer capacity) {
            this.aircraft.capacity = capacity;
            return this;
        }

        @Override
        public AircraftBuilders.NumberPlate model(String model) {
            this.aircraft.model = model;
            return this;
        }

        @Override
        public AircraftBuilders.Build numberPlate(String numberPlate) {
            this.aircraft.numberPlate = numberPlate;
            return this;
        }

        @Override
        public Aircraft build() {
            return this.aircraft;
        }
    }
}
