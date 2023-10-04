package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document
public class RaceEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String circuitName;
    private String hostCountry;
    private LocalDate date;
    @DBRef
    private List<DriverEntity> driverEntities;
    private Integer laps;
    private Boolean nightRace;

    public RaceEntity() {
        //empty for framework
    }

    public RaceEntity(String circuitName, String hostCountry, LocalDate date, List<DriverEntity> driverEntities) {
        this.id = UUID.randomUUID().toString();
        this.circuitName = circuitName;
        this.hostCountry = hostCountry;
        this.date = date;
        this.driverEntities = driverEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<DriverEntity> getDriverEntities() {
        return driverEntities;
    }

    public void setDriverEntities(List<DriverEntity> driverEntities) {
        this.driverEntities = driverEntities;
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
        return "RaceEntity{" +
                "id='" + id + '\'' +
                ", circuitName='" + circuitName + '\'' +
                ", hostCountry='" + hostCountry + '\'' +
                ", date=" + date +
                ", drivers=" + driverEntities +
                ", laps=" + laps +
                ", nightRace=" + nightRace +
                '}';
    }
}
