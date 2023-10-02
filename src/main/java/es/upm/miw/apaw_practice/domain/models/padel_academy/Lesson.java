package es.upm.miw.apaw_practice.domain.models.padel_academy;

import java.time.LocalDate;
import java.util.List;

public class Lesson {
    private String id;
    private LocalDate startAt;
    private Boolean weekend;
    private String level;
    private List<Instructor> instructors;

    public Lesson(List<Instructor> instructors) {
        this.instructors = instructors;
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

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id='" + id + '\'' +
                ", startAt=" + startAt +
                ", weekend=" + weekend +
                ", level='" + level + '\'' +
                ", instructors=" + instructors +
                '}';
    }
}