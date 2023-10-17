package es.upm.miw.apaw_practice.adapters.mongodb.aquarium.entities;
import es.upm.miw.apaw_practice.domain.models.aquarium.Fish;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
@Document
public class FishEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String species;
    private String color;
    private LocalDate dateOfEntrance;

    public FishEntity() {
        //empty for framework
    }

    public FishEntity(String species, String color, LocalDate dateOfEntrance) {
        this.id = UUID.randomUUID().toString();
        this.species = species;
        this.color = color;
        this.dateOfEntrance = dateOfEntrance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getDateOfEntrance() {
        return dateOfEntrance;
    }

    public void setDateOfEntrance(LocalDate dateOfEntrance) {
        this.dateOfEntrance = dateOfEntrance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FishEntity that)) return false;
        return (Objects.equals(getId(), that.getId()) || Objects.equals(getColor(), that.getColor())||Objects.equals(getSpecies(),that.getSpecies()));
    }
    public Fish toFish(){
        return new Fish(species,color,dateOfEntrance);
    }
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "FishEntity{" +
                "id='" + id + '\'' +
                ", species='" + species + '\'' +
                ", color='" + color + '\'' +
                ", dateOfEntrance=" + dateOfEntrance +
                '}';
    }
}
