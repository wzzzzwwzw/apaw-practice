package es.upm.miw.apaw_practice.domain.models.school;

import java.time.LocalDateTime;

public class Classroom {
    private String location;
    private LocalDateTime entryHour;
    private Boolean smartBoard;
    private Integer lockers;

    public Classroom() {
        //empty from framework
    }

    public Classroom(String location, LocalDateTime entryHour, Boolean smartBoard, Integer lockers) {
        this.location = location;
        this.entryHour = entryHour;
        this.smartBoard = smartBoard;
        this.lockers = lockers;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getEntryHour() {
        return entryHour;
    }

    public void setEntryHour(LocalDateTime entryHour) {
        this.entryHour = entryHour;
    }

    public Boolean getSmartBoard() {
        return smartBoard;
    }

    public void setSmartBoard(Boolean smartBoard) {
        this.smartBoard = smartBoard;
    }

    public Integer getLockers() {
        return lockers;
    }

    public void setLockers(Integer lockers) {
        this.lockers = lockers;
    }

    public void doDefault() {
        this.location = "default";
        this.entryHour = LocalDateTime.of(2001, 1, 1, 1, 1);
        this.smartBoard = true;
        this.lockers = 0;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "location='" + location + '\'' +
                ", entryHour=" + entryHour +
                ", smartBoard=" + smartBoard +
                ", lockers=" + lockers +
                '}';
    }
}
