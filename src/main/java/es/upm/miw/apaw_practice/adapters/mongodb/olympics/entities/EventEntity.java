package es.upm.miw.apaw_practice.adapters.mongodb.olympics.entities;

import es.upm.miw.apaw_practice.domain.models.olympics.Athlete;
import es.upm.miw.apaw_practice.domain.models.olympics.Event;
import es.upm.miw.apaw_practice.domain.models.olympics.Sport;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
public class EventEntity {
    @Id
    private String id;
    private LocalDateTime dateTime;
    private String location;
    private Boolean awardsMedals;
    private SportEntity sportEntity;
    private List<AthleteEntity> athleteEntities;

    public EventEntity(String id, LocalDateTime dateTime, String location, Boolean awardsMedals, SportEntity sportEntity, List<AthleteEntity> athleteEntities) {
        this.id = id;
        this.dateTime = dateTime;
        this.location = location;
        this.awardsMedals = awardsMedals;
        this.sportEntity = sportEntity;
        this.athleteEntities = athleteEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getAwardsMedals() {
        return awardsMedals;
    }

    public void setAwardsMedals(Boolean awardsMedals) {
        this.awardsMedals = awardsMedals;
    }

    public SportEntity getSportEntity() {
        return sportEntity;
    }

    public void setSportEntity(SportEntity sportEntity) {
        this.sportEntity = sportEntity;
    }

    public List<AthleteEntity> getAthleteEntities() {
        return athleteEntities;
    }

    public void setAthleteEntities(List<AthleteEntity> athleteEntities) {
        this.athleteEntities = athleteEntities;
    }

    public Event toEvent() {
        List<Athlete> athletes = this.athleteEntities.stream()
                .map(AthleteEntity::toAthlete)
                .toList();
        Sport sport = this.sportEntity.toSport();

        return new Event(id, dateTime, location, awardsMedals, sport, athletes);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((EventEntity) obj).id));
    }

    @Override
    public String toString() {
        return "EventEntity{" +
                "id='" + id + '\'' +
                ", dateTime=" + dateTime +
                ", location='" + location + '\'' +
                ", awardsMedals=" + awardsMedals +
                ", sportEntity=" + sportEntity +
                ", athleteEntities=" + athleteEntities +
                '}';
    }
}
