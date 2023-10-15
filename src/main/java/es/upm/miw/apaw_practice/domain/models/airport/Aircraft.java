package es.upm.miw.apaw_practice.domain.models.airport;

import java.time.LocalDate;

public class Aircraft {

    private LocalDate dateOfLastRevision;
    private Integer capacity;
    private String model;

    public Aircraft(){
        //empty for framework
    }
    public Aircraft(LocalDate dateOfLastRevision, Integer capacity, String model) {
        this.dateOfLastRevision = dateOfLastRevision;
        this.capacity = capacity;
        this.model = model;
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

    @Override
    public String toString() {
        return "Aircraft{" +
                "dateOfLastRevision=" + dateOfLastRevision +
                ", capacity=" + capacity +
                ", model='" + model + '\'' +
                '}';
    }
}
