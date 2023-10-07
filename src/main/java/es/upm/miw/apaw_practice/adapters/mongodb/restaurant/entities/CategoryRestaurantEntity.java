package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities;

import es.upm.miw.apaw_practice.domain.models.restaurant.CategoryRestaurant;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Document
public class CategoryRestaurantEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String tag;
    private String color;
    private LocalDateTime creationDate;

    public CategoryRestaurantEntity() {
        //empty from framework
    }

    public CategoryRestaurantEntity(String tag, String color) {
        this.id = UUID.randomUUID().toString();
        this.tag = tag;
        this.color = color;
        this.creationDate = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public CategoryRestaurant toCategoryRestaurant() {
        CategoryRestaurant categoryRestaurant = new CategoryRestaurant();
        BeanUtils.copyProperties(this, categoryRestaurant);
        return categoryRestaurant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryRestaurantEntity that = (CategoryRestaurantEntity) o;
        return Objects.equals(tag, that.tag) && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag, color);
    }

    @Override
    public String toString() {
        return "CategoryRestaurantEntity{" +
                "id='" + id + '\'' +
                ", tag='" + tag + '\'' +
                ", color='" + color + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

}
