package es.upm.miw.apaw_practice.domain.models.museum;

import java.time.LocalDate;

public class Room {
    private String name;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;

    public Room() { }

    public Room(String name, String location, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
