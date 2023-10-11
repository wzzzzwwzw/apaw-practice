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
    private String style;
    @Indexed(unique = true)
    private String category;
    private String description;
    private LocalDateTime startDate;
    @DBRef
    private List<InscriptionEntity> inscriptionEntities;

    public LessonEntity() {
        // empty for framework
    }

    public LessonEntity(String style, String category, String description, LocalDateTime startDate, List<InscriptionEntity> inscriptionEntities) {
        this.id = UUID.randomUUID().toString();
        this.style = style;
        this.category = category;
        this.description = description;
        this.startDate = startDate;
        this.inscriptionEntities = inscriptionEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                ", style='" + style + '\'' +
                ", category='" + category + '\'' +
                ", description=" + description + '\'' +
                ", description=" + startDate + '\'' +
                ", inscriptionEntities=" + inscriptionEntities +
                '}';
    }
}
