package es.upm.miw.apaw_practice.domain.models.padel_academy;

import java.util.ArrayList;
import java.util.List;

public class Court {
    private Integer number;
    private Boolean roof;
    private String surface;
    private List<Instructor> instructors;
    private List<Lesson> lessons;

    public Court(Integer number, Boolean roof, String surface, List<Instructor> instructors) {
        this.number = number;
        this.roof = roof;
        this.surface = surface;
        this.instructors = instructors;
        this.lessons = new ArrayList<Lesson>();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getRoof() {
        return roof;
    }

    public void setRoof(Boolean roof) {
        this.roof = roof;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "Court{" +
                "number=" + number +
                ", roof=" + roof +
                ", surface='" + surface + '\'' +
                ", instructors=" + instructors +
                ", lessons=" + lessons +
                '}';
    }
}
