package es.upm.miw.apaw_practice.adapters.mongodb.swimming.entities;

import es.upm.miw.apaw_practice.domain.models.swimming.Tutor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class TutorEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String appellation;
    private String specialty;
    private Integer experience;
    @DBRef
    private LessonEntity lessonEntity;

    public TutorEntity() {
        //empty for framework
    }

    public TutorEntity(String appellation, String specialty, Integer experience, LessonEntity lessonEntity) {
        this.id = UUID.randomUUID().toString();
        this.appellation = appellation;
        this.specialty = specialty;
        this.experience = experience;
        this.lessonEntity = lessonEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Tutor toTutor() {
        Tutor tutor = new Tutor();
        BeanUtils.copyProperties(this, tutor);
        return tutor;
    }

    public LessonEntity getLessonEntity() {
        return lessonEntity;
    }

    public void setLessonEntity(LessonEntity lessonEntity) {
        this.lessonEntity = lessonEntity;
    }

    @Override
    public int hashCode() {
        return this.appellation.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null
                && getClass() == obj.getClass()
                && (appellation.equals(((TutorEntity) obj).appellation));
    }

    @Override
    public String toString() {
        return "TutorEntity{" +
                "id='" + id + '\'' +
                ", appellation='" + appellation + '\'' +
                ", specialty='" + specialty + '\'' +
                ", experience=" + experience + '\'' +
                ", lessonEntity=" + lessonEntity +
                '}';
    }

}
