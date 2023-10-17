package es.upm.miw.apaw_practice.adapters.mongodb.school.entities;

import es.upm.miw.apaw_practice.domain.models.school.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class SubjectEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String title;
    private String description;
    private Boolean bilingual;
    private Integer credits;

    public SubjectEntity () {
        // Empty for framework
    }

    public SubjectEntity(Subject subject) {
        BeanUtils.copyProperties(subject, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getBilingual() {
        return bilingual;
    }

    public void setBilingual(Boolean bilingual) {
        this.bilingual = bilingual;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubjectEntity that)) return false;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public Subject toSubject() {
        return new Subject(this.title, this.description, this.bilingual, this.credits);
    }

    public void fromSubject(Subject subject) {
        BeanUtils.copyProperties(subject, this);
    }

    @Override
    public String toString() {
        return "SubjectEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", bilingual=" + bilingual +
                ", credits=" + credits +
                '}';
    }
}
