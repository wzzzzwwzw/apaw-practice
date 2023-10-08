package es.upm.miw.apaw_practice.domain.models.stable;

import java.util.ArrayList;
import java.util.List;

public class CareTask {
    private String description;
    private Double durationHours;
    private List<Horse> horses;
    public CareTask() {
    }

    public CareTask(String description, Double durationHours) {
        this.description = description;
        this.durationHours = durationHours;
        this.horses = new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(Double durationHours) {
        this.durationHours = durationHours;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }

    public void addHorses(Horse horse) {
        horses.add(horse);
    }

    public void removeHorse(Horse horse) {
        horses.remove(horse);
    }

    @Override
    public String toString() {
        return "CareTask{" +
                "description='" + description + '\'' +
                ", durationHours=" + durationHours +
                ", horses=" + horses +
                '}';
    }
}