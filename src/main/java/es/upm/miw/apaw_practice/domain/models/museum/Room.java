package es.upm.miw.apaw_practice.domain.models.museum;

public class Room {
    private String description;
    private Integer floor;
    private Double popularity;

    public Room() { }

    public Room(String description, Integer floor, Double popularity) {
        this.description = description;
        this.floor = floor;
        this.popularity = popularity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }
}
