package es.upm.miw.apaw_practice.domain.models.climbing;

public class Route {
    private String key;
    private String name;
    private String difficulty;

    public Route() {

    }

    public Route(String key, String name, String difficulty) {
        this.key = key;
        this.name = name;
        this.difficulty = difficulty;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Route{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}
