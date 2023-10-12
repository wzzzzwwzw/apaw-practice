package es.upm.miw.apaw_practice.adapters.mongodb.airport.entities;

import es.upm.miw.apaw_practice.domain.models.airport.Aircraft;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Document
public class AircraftEntity {
    @Id
    private String id;
    private LocalDate dateOfLastRevision;
    private Integer capacity;
    private String model;

    public AircraftEntity(){
        //empty for framework
    }

    public AircraftEntity(Aircraft aircraft) {
        BeanUtils.copyProperties(aircraft, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((AircraftEntity) obj).id));
    }

    @Override
    public String toString() {
        return "AircraftEntity{" +
                "id='" + id + '\'' +
                ", dateOfLastRevision=" + dateOfLastRevision +
                ", capacity=" + capacity +
                ", model='" + model + '\'' +
                '}';
    }
}
