package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class DrivingStyleEntity {

    @Id
    private String id;
    private Integer aggressiveness;
    private Integer consistency;
    private Integer adaptability;
    private Integer tireManagement;
    private Integer fuelManagement;

    public DrivingStyleEntity() {
        //empty for framework
    }

    public DrivingStyleEntity(Integer aggressiveness, Integer consistency, Integer adaptability, Integer tireManagement, Integer fuelManagement) {
        this.id = UUID.randomUUID().toString();
        this.aggressiveness = aggressiveness;
        this.consistency = consistency;
        this.adaptability = adaptability;
        this.tireManagement = tireManagement;
        this.fuelManagement = fuelManagement;
    }

    public String getId() {
        return id;
    }

    public Integer getAggressiveness() {
        return aggressiveness;
    }

    public void setAggressiveness(Integer aggressiveness) {
        this.aggressiveness = aggressiveness;
    }

    public Integer getConsistency() {
        return consistency;
    }

    public void setConsistency(Integer consistency) {
        this.consistency = consistency;
    }

    public Integer getAdaptability() {
        return adaptability;
    }

    public void setAdaptability(Integer adaptability) {
        this.adaptability = adaptability;
    }

    public Integer getTireManagement() {
        return tireManagement;
    }

    public void setTireManagement(Integer tireManagement) {
        this.tireManagement = tireManagement;
    }

    public Integer getFuelManagement() {
        return fuelManagement;
    }

    public void setFuelManagement(Integer fuelManagement) {
        this.fuelManagement = fuelManagement;
    }

    @Override
    public String toString() {
        return "DrivingStyleEntity{" +
                "id='" + id + '\'' +
                ", aggressiveness=" + aggressiveness +
                ", consistency=" + consistency +
                ", adaptability=" + adaptability +
                ", tireManagement=" + tireManagement +
                ", fuelManagement=" + fuelManagement +
                '}';
    }
}
