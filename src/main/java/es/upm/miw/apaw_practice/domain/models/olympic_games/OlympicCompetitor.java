package es.upm.miw.apaw_practice.domain.models.olympic_games;

public class OlympicCompetitor {
    private String name;
    private String nationality;
    private Integer age;

    public OlympicCompetitor() {
    }


    public OlympicCompetitor(String name, String nationality, Integer age) {
        this.name = name;
        this.nationality = nationality;
        this.age = age;
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

    @Override
    public String toString() {
        return "OlympicCompetitor{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", age=" + age +
                '}';
    }
}
