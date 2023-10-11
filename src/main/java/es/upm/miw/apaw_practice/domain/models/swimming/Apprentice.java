package es.upm.miw.apaw_practice.domain.models.swimming;

import java.util.ArrayList;
import java.util.List;

public class Apprentice {

    private String fullName;
    private Integer age;
    private String address;
    private List<Lesson> lessons;
    private Inscription inscription;

    public Apprentice() {
        lessons = new ArrayList<>();
    }

    public Apprentice(String fullName, Integer age, String address, List<Lesson> lessons, Inscription inscription) {
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.lessons = lessons;
        this.inscription = inscription;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String name) {
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

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void addLesson(Lesson lesson) {
        this.lessons.add(lesson);
    }

    public Inscription getInscription(){
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    @Override
    public String toString() {
        return "Apprentice{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age + '\'' +
                ", address='" + address + '\'' +
                ", lessons='" + lessons + '\'' +
                ", inscription='" + inscription +
                '}';
    }
}
