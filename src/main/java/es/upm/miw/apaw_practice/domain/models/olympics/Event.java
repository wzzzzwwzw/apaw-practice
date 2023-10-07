package es.upm.miw.apaw_practice.domain.models.olympics;

import java.time.LocalDateTime;
import java.util.List;

public class Event {
    private String id;
    private LocalDateTime dateTime;
    private String location;
    private Boolean awardsMedals;
    private Sport sport;
    private List<Athlete> athletes;

    public Event() {
        // empty for framework
    }

    public Event(String id, LocalDateTime dateTime, String location, Boolean awardsMedals, Sport sport, List<Athlete> athletes) {
        this.id = id;
        this.dateTime = dateTime;
        this.location = location;
        this.awardsMedals = awardsMedals;
        this.sport = sport;
        this.athletes = athletes;
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

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public List<Athlete> getAthletes() {
        return athletes;
    }

    public void setAthletes(List<Athlete> athletes) {
        this.athletes = athletes;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", dateTime=" + dateTime +
                ", location='" + location + '\'' +
                ", awardsMedals=" + awardsMedals +
                ", sport=" + sport +
                ", athletes=" + athletes +
                '}';
    }
}
