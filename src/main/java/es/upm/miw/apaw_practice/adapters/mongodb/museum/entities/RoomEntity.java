package es.upm.miw.apaw_practice.adapters.mongodb.museum.entities;

import es.upm.miw.apaw_practice.domain.models.museum.Room;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class RoomEntity {
    @Id
    private String description;
    private Integer floor;
    private Double popularity;

    public RoomEntity() {
        // Empty for framework
    }

    public RoomEntity(Room room) {
        fromRoom(room);
    }

    public RoomEntity(String description, Integer floor, Double popularity) {
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

    public void fromRoom(Room room) {
        BeanUtils.copyProperties(room, this);
    }

    public Room toRoom() {
        return new Room(this.description, this.floor, this.popularity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomEntity that = (RoomEntity) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    @Override
    public String toString() {
        return "RoomEntity{" +
                "description='" + description + '\'' +
                ", floor=" + floor +
                ", popularity=" + popularity +
                '}';
    }
}
