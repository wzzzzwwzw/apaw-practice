package es.upm.miw.apaw_practice.domain.models.climbing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Climber {
    private String name;
    private LocalDate dateOfBirth;
    private String level;
    private List<Expedition> expeditions;

    public Climber() {
        this.expeditions = new ArrayList<>();
    }

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

    public List<Expedition> getExpeditions() {
        return this.expeditions;
    }

    public void setExpeditions(List<Expedition> expeditions) {
        this.expeditions = expeditions;
    }

    public void addExpedition(Expedition expedition) {
        this.expeditions.add(expedition);
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
