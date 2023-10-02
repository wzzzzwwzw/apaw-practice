package es.upm.miw.apaw_practice.domain.models.videogame_company;

public class GameEngine {
    private String name;
    private String ProgrammingLanguage;
    private String License;

    public GameEngine(){

    }
    public GameEngine(String name, String programmingLanguage, String license) {
        this.name = name;
        ProgrammingLanguage = programmingLanguage;
        License = license;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgrammingLanguage() {
        return ProgrammingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        ProgrammingLanguage = programmingLanguage;
    }

    public String getLicense() {
        return License;
    }

    public void setLicense(String license) {
        License = license;
    }

    @Override
    public String toString() {
        return "GameEngine{" +
                "name='" + name + '\'' +
                ", ProgrammingLanguage='" + ProgrammingLanguage + '\'' +
                ", License='" + License + '\'' +
                '}';
    }
}
