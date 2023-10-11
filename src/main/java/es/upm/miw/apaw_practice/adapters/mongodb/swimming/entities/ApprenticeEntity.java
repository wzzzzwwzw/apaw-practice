package es.upm.miw.apaw_practice.adapters.mongodb.swimming.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;
import java.util.UUID;

public class ApprenticeEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String fullName;
    private Integer age;
    private String address;
    private List<LessonEntity> lessonEntities;
    @DBRef
    private InscriptionEntity inscriptionEntity;

    public ApprenticeEntity() {
        // empty for framework
    }

    public ApprenticeEntity(String fullName, Integer age, String address, List<LessonEntity> lessonEntities, InscriptionEntity inscriptionEntity) {
        this.id = UUID.randomUUID().toString();
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.lessonEntities = lessonEntities;
        this.inscriptionEntity = inscriptionEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<LessonEntity> getLessonEntities() {
        return lessonEntities;
    }

    public void setLessonEntities(List<LessonEntity> lessonEntities) {
        this.lessonEntities = lessonEntities;
    }

    public InscriptionEntity getInscriptionEntity() {
        return inscriptionEntity;
    }

    public void setInscriptionEntity(InscriptionEntity inscriptionEntity) {
        this.inscriptionEntity = inscriptionEntity;
    }

    @Override
    public int hashCode() {
        return this.fullName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (fullName.equals(((ApprenticeEntity) obj).fullName));
    }

    @Override
    public String toString() {
        return "ApprenticeEntity{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", age='" + age + '\'' +
                ", address=" + address + '\'' +
                ", lessonEntities=" + lessonEntities + '\'' +
                ", inscriptionEntity=" + inscriptionEntity +
                '}';
    }

}
