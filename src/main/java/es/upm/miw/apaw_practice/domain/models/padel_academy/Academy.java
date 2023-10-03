package es.upm.miw.apaw_practice.domain.models.padel_academy;

import java.util.ArrayList;
import java.util.List;

public class Academy {
    private String name;
    private String address;
    private String city;
    private List<Instructor> instructors;
    private List<Court> courts;

    public Academy(String name, String address, String city, List<Instructor> instructors) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.instructors = instructors;
        this.courts = new ArrayList<Court>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<Court> getCourts() {
        return courts;
    }

    public void setCourts(List<Court> courts) {
        this.courts = courts;
    }

    @Override
    public String toString() {
        return "Academy{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", instructors=" + instructors +
                ", courts=" + courts +
                '}';
    }
}
