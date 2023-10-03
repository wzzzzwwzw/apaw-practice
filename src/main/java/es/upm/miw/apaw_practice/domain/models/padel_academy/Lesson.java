package es.upm.miw.apaw_practice.domain.models.padel_academy;

import java.time.LocalDate;
import java.util.List;

public class Lesson {
    private String id;
    private LocalDate startAt;
    private Boolean weekend;
    private String level;
    private Instructor instructor;

    public Lesson(Instructor instructor) {
        this.instructor = instructor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalDate startAt) {
        this.startAt = startAt;
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

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id='" + id + '\'' +
                ", startAt=" + startAt +
                ", weekend=" + weekend +
                ", level='" + level + '\'' +
                ", instructors=" + instructor +
                '}';
    }
}