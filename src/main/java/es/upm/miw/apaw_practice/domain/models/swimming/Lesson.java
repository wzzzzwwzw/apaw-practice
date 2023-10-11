package es.upm.miw.apaw_practice.domain.models.swimming;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Lesson {
    private String style;
    private String category;
    private String description;
    private LocalDateTime startDate;
    private List<Inscription> inscriptions;

    public Lesson() {
        inscriptions = new ArrayList<>();
    }

    public Lesson(String style, String category, String description, LocalDateTime startDate, List<Inscription> inscriptions) {
        this.style = style;
        this.category = category;
        this.description = description;
        this.startDate = startDate;
        this.inscriptions = inscriptions;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public void addInscription(Inscription inscription) {
        this.inscriptions.add(inscription);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "style='" + style + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", startDate='" + startDate + '\'' +
                ", inscriptions='" + inscriptions +
                '}';
    }
}
