package es.upm.miw.apaw_practice.domain.models.stable;

public class CareTask {
    private String description;
    private Double durationHours;
    public CareTask() {
    }

    public CareTask(String description, Double durationHours) {
        this.description = description;
        this.durationHours = durationHours;
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

    @Override
    public String toString() {
        return "CareTask{" +
                "description='" + description + '\'' +
                ", durationHours=" + durationHours +
                '}';
    }
}