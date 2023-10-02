package es.upm.miw.apaw_practice.domain.models.padel_academy;

import java.time.LocalDate;

public class Lesson {
    private String id;
    private LocalDate schedule;
    private Boolean weekend;
    private String level;

    public Lesson(String id, LocalDate schedule, Boolean weekend, String level) {
        this.id = id;
        this.schedule = schedule;
        this.weekend = weekend;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDate schedule) {
        this.schedule = schedule;
    }

    public Boolean getWeekend() {
        return weekend;
    }

    public void setWeekend(Boolean weekend) {
        this.weekend = weekend;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id='" + id + '\'' +
                ", schedule=" + schedule +
                ", weekend=" + weekend +
                ", level='" + level + '\'' +
                '}';
    }
}