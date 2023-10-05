package es.upm.miw.apaw_practice.domain.models.swimming;

import java.time.LocalDateTime;

public class Lesson {
    private String style;
    private String category;
    private String description;
    private LocalDateTime startDate;

    public Lesson() {
        //empty for framework
    }

    public Lesson(String style, String category, String description,LocalDateTime startDate) {
        this.style = style;
        this.category = category;
        this.description = description;
        this.startDate = startDate;
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


    @Override
    public String toString() {
        return "Lesson{" +
                "style='" + style + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", startDate='" + startDate + '\'' +
                '}';
    }
}
