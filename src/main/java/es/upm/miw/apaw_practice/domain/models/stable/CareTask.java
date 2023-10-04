package es.upm.miw.apaw_practice.domain.models.stable;

public class CareTask {
    private String description;
    private double durationHours;

    public CareTask(String description, double durationHours) {
        this.description = description;
        this.durationHours = durationHours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(double durationHours) {
        this.durationHours = durationHours;
    }
}