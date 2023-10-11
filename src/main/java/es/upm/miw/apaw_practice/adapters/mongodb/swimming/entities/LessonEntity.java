package es.upm.miw.apaw_practice.adapters.mongodb.swimming.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Document
public class LessonEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String swimStyle;
    @Indexed(unique = true)
    private String swimRange;
    private String description;
    private LocalDateTime lessonDay;
    @DBRef
    private List<InscriptionEntity> inscriptionEntities;

    public LessonEntity() {
        // empty for framework
    }

    public LessonEntity(String swimStyle, String swimRange, String description, LocalDateTime lessonDay, List<InscriptionEntity> inscriptionEntities) {
        this.id = UUID.randomUUID().toString();
        this.swimStyle = swimStyle;
        this.swimRange = swimRange;
        this.description = description;
        this.lessonDay = lessonDay;
        this.inscriptionEntities = inscriptionEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<InscriptionEntity> getInscriptionEntities() {
        return inscriptionEntities;
    }

    public void setInscriptionEntities(List<InscriptionEntity> inscriptionEntities) {
        this.inscriptionEntities = inscriptionEntities;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null
                && getClass() == obj.getClass()
                && (id.equals(((LessonEntity) obj).id));
    }

    @Override
    public String toString() {
        return "InscriptionEntity{" +
                "id='" + id + '\'' +
                ", swimStyle='" + swimStyle + '\'' +
                ", swimRange='" + swimRange + '\'' +
                ", description=" + description + '\'' +
                ", lessonDay=" + lessonDay + '\'' +
                ", inscriptionEntities=" + inscriptionEntities +
                '}';
    }
}
