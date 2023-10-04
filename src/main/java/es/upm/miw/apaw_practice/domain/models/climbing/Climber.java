package es.upm.miw.apaw_practice.domain.models.climbing;

import java.time.LocalDate;

public class Climber {
    private String name;
    private LocalDate dateOfBirth;
    private String level;

    public Climber(String name, LocalDate dateOfBirth, String level) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Climber{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", level='" + level + '\'' +
                '}';
    }
}
