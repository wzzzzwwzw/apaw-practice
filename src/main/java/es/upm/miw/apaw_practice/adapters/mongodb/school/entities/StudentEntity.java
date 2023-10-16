package es.upm.miw.apaw_practice.adapters.mongodb.school.entities;

import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import es.upm.miw.apaw_practice.domain.models.school.Student;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class StudentEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private Integer age;
    private long contact;
    private String email;
    private ClassroomEntity classroomEntity;
    @DBRef
    private List<SubjectEntity> subjectsEntities;

    public StudentEntity() {
        //empty from framework
    }

    public StudentEntity(Student student) {
        BeanUtils.copyProperties(student, this);
        this.id = UUID.randomUUID().toString();
    }

    public StudentEntity(String name, Integer age, long contact, String email, ClassroomEntity classroomEntity, List<SubjectEntity> subjectsEntities) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.email = email;
        this.classroomEntity = classroomEntity;
        this.subjectsEntities = subjectsEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClassroomEntity getClassroom() {
        return classroomEntity;
    }

    public void setClassroom(ClassroomEntity classroomEntity) {
        this.classroomEntity = classroomEntity;
    }

    public List<SubjectEntity> getSubjectsEntities() {
        return subjectsEntities;
    }

    public void setSubjectsEntities(List<SubjectEntity> subjectsEntities) {
        this.subjectsEntities = subjectsEntities;
    }

    public Student toStudent() {
        Student student = new Student(this.name, this.age, this.contact, this.email, this.classroomEntity.toClassroom());
        student.setSubjects(this.subjectsEntities.stream()
                .map(SubjectEntity::toSubject).toList());
        return student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentEntity that)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
