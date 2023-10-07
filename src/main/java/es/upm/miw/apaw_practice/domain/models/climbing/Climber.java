package es.upm.miw.apaw_practice.domain.models.climbing;

import java.time.LocalDate;
import java.util.List;

public class Climber {
    private String email;
    private LocalDate dateOfBirth;
    private String level;
    private List<Expedition> expeditions;

    public Climber() {

    }

    public Climber(String email, LocalDate dateOfBirth, String level, List<Expedition> expeditions) {
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.level = level;
        this.expeditions = expeditions;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return expeditions;
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
                "email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", level='" + level + '\'' +
                ", expeditions=" + expeditions +
                '}';
    }
}
