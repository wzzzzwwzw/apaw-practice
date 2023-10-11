package es.upm.miw.apaw_practice.domain.models.swimming;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Lesson {
    private String swimStyle;
    private String swimRange;
    private String description;
    private LocalDateTime lessonDay;
    private List<Inscription> inscriptions;

    public Lesson() {
        inscriptions = new ArrayList<>();
    }

    public Lesson(String swimStyle, String swimRange, String description, LocalDateTime lessonDay, List<Inscription> inscriptions) {
        this.swimStyle = swimStyle;
        this.swimRange = swimRange;
        this.description = description;
        this.lessonDay = lessonDay;
        this.inscriptions = inscriptions;
    }

    public String getSwimStyle() {
        return swimStyle;
    }

    public void setSwimStyle(String swimStyle) {
        this.swimStyle = swimStyle;
    }

    public String getSwimRange() {
        return swimRange;
    }

    public void setSwimRange(String swimRange) {
        this.swimRange = swimRange;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getLessonDay() {
        return lessonDay;
    }

    public void setLessonDay(LocalDateTime lessonDay) {
        this.lessonDay = lessonDay;
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
                "swimStyle='" + swimStyle + '\'' +
                ", swimRange='" + swimRange + '\'' +
                ", description='" + description + '\'' +
                ", lessonDay='" + lessonDay + '\'' +
                ", inscriptions='" + inscriptions +
                '}';
    }
}
