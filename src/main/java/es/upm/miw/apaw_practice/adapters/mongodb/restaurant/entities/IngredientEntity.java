package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class IngredientEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private Boolean spicy;
    private Boolean available;

    IngredientEntity() {
        //empty from framework
    }

    public IngredientEntity(String name, Boolean spicy, Boolean available) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.spicy = spicy;
        this.available = available;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isSpicy() {
        return spicy;
    }

    public void setSpicy(Boolean spicy) {
        this.spicy = spicy;
    }

    public Boolean isAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngredientEntity that = (IngredientEntity) o;
        return Objects.equals(name, that.name) && Objects.equals(spicy, that.spicy) && Objects.equals(available, that.available);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, spicy, available);
    }

    @Override
    public String toString() {
        return "IngredientEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", spicy=" + spicy +
                ", available=" + available +
                '}';
    }

}
