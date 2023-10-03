package es.upm.miw.apaw_practice.domain.models.climbing;

public class Route {
    private String description;
    private String difficulty;
    private String type;

    public Route(String description, String difficulty, String type) {
        this.description = description;
        this.difficulty = difficulty;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Route{" +
                "description='" + description + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
