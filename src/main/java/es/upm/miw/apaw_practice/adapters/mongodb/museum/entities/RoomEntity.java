package es.upm.miw.apaw_practice.adapters.mongodb.museum.entities;

import es.upm.miw.apaw_practice.domain.models.museum.Room;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class RoomEntity {
    @Id
    private String id;
    private String description;
    private Integer floor;
    private Double popularity;

    public RoomEntity() {
        // Empty for framework
    }

    public RoomEntity(String description, Integer floor, Double popularity) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.floor = floor;
        this.popularity = popularity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Room toRoom() {
        return new Room(this.description, this.floor, this.popularity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomEntity that = (RoomEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RoomEntity{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", floor=" + floor +
                ", popularity=" + popularity +
                '}';
    }
}
