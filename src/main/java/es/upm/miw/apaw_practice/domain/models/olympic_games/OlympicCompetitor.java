package es.upm.miw.apaw_practice.domain.models.olympic_games;

import java.util.List;

public class OlympicCompetitor {
    private String name;
    private String nationality;
    private Integer age;

    private List<OlympicMedal> medals;

    public OlympicCompetitor() {
    }


    public OlympicCompetitor(String name, String nationality, Integer age, List<OlympicMedal> medals) {
        this.name = name;
        this.nationality = nationality;
        this.age = age;
        this.medals = medals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<OlympicMedal> getMedals() {
        return medals;
    }

    public void setMedals(List<OlympicMedal> medals) {
        this.medals = medals;
    }

    @Override
    public String toString() {
        return "OlympicCompetitor{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", age=" + age +
                ", medals=" + medals +
                '}';
    }
}
