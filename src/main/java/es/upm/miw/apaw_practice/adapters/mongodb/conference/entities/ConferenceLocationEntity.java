package es.upm.miw.apaw_practice.adapters.mongodb.conference.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class ConferenceLocationEntity {
    @Id
    private String id;
    private String city;
    private String building;
    private String hall;

    public ConferenceLocationEntity() {
        //empty for framework
    }

    public ConferenceLocationEntity(String city, String building, String hall) {
        this.id = UUID.randomUUID().toString();
        this.city = city;
        this.building = building;
        this.hall = hall;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConferenceLocationEntity that = (ConferenceLocationEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ConferenceLocationEntity{" +
                "id='" + id + '\'' +
                ", city='" + city + '\'' +
                ", building='" + building + '\'' +
                ", hall='" + hall + '\'' +
                '}';
    }
}
