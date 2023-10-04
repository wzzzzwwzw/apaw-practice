package es.upm.miw.apaw_practice.domain.models.school;

import java.util.List;

public class Student {
    private String name;
    private Integer age;
    private long contact;
    private String email;
    private Classroom classroom;
    private List<Subject> subjects;
    public Student() {
        //empty from framework
    }

    public Student(String name, Integer age, long contact, String email, Classroom classroom) {
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.email = email;
        this.classroom = classroom;
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

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", contact=" + contact +
                ", email='" + email + '\'' +
                ", classroom=" + classroom +
                ", subjects=" + subjects +
                '}';
    }
}
