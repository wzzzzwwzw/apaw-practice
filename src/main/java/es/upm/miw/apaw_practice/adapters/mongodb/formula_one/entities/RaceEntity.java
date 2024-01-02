package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities;

import es.upm.miw.apaw_practice.domain.models.formula_one.Driver;
import es.upm.miw.apaw_practice.domain.models.formula_one.Race;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Document
public class RaceEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String circuitName;
    private String hostCountry;
    private LocalDate date;
    @DBRef
    private List<DriverEntity> raceDriverEntities;
    private Integer laps;
    private Boolean nightRace;

    public RaceEntity() {
        //empty for framework
    }

    public RaceEntity(String circuitName, String hostCountry, LocalDate date, List<DriverEntity> raceDriverEntities) {
        this.id = UUID.randomUUID().toString();
        this.circuitName = circuitName;
        this.hostCountry = hostCountry;
        this.date = date;
        this.raceDriverEntities = raceDriverEntities;
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

    public List<DriverEntity> getRaceDriverEntities() {
        return raceDriverEntities;
    }

    public void setRaceDriverEntities(List<DriverEntity> raceDriverEntities) {
        this.raceDriverEntities = raceDriverEntities;
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

    public Race toRace() {
        Race race = new Race();
        BeanUtils.copyProperties(this, race, "raceDriverEntities");
        List<Driver> raceDrivers = this.raceDriverEntities.stream()
                .map(DriverEntity::toDriver)
                .toList();
        race.setRaceDrivers(raceDrivers);
        return race;
    }

    @Override
    public String toString() {
        return "RaceEntity{" +
                "id='" + id + '\'' +
                ", circuitName='" + circuitName + '\'' +
                ", hostCountry='" + hostCountry + '\'' +
                ", date=" + date +
                ", raceDrivers=" + raceDriverEntities +
                ", laps=" + laps +
                ", nightRace=" + nightRace +
                '}';
    }
}
