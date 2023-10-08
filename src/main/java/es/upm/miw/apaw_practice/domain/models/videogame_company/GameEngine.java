package es.upm.miw.apaw_practice.domain.models.videogame_company;

public class GameEngine {
    private String name;
    private String programmingLanguage;
    private String license;

    public GameEngine(){

    }
    public GameEngine(String name, String programmingLanguage, String license) {
        this.name = name;
        this.programmingLanguage = programmingLanguage;
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        programmingLanguage = programmingLanguage;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        license = license;
    }

    @Override
    public String toString() {
        return "GameEngine{" +
                "name='" + name + '\'' +
                ", ProgrammingLanguage='" + programmingLanguage + '\'' +
                ", License='" + license + '\'' +
                '}';
    }
}
