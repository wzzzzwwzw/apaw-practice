package es.upm.miw.apaw_practice.domain.models.padel_academy;

import java.time.LocalDate;
import java.util.List;

public class Lesson {
    private String id;
    private LocalDate schedule;
    private Boolean isWeekend;
    private String level;

    public Lesson(String id, LocalDate schedule, Boolean isWeekend, String level) {
        this.id = id;
        this.schedule = schedule;
        this.isWeekend = isWeekend;
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
        return isWeekend;
    }

    public void setWeekend(Boolean weekend) {
        isWeekend = weekend;
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
                ", isWeekend=" + isWeekend +
                ", level='" + level + '\'' +
                '}';
    }
}