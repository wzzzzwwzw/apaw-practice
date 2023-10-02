package es.upm.miw.apaw_practice.domain.models.restaurant;

import java.time.LocalDateTime;
import java.util.Objects;

public class CategoryRestaurant {

    private String tag;
    private String color;
    private LocalDateTime creationDate;

    public CategoryRestaurant() {
        //empty from framework
    }

    public CategoryRestaurant(String tag, String color) {
        this.tag = tag;
        this.color = color;
        this.creationDate = LocalDateTime.now();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryRestaurant that = (CategoryRestaurant) o;
        return tag.equals(that.tag) && Objects.equals(color, that.color) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag, color, creationDate);
    }

    @Override
    public String toString() {
        return "CategoryRestaurant{" +
                "tag='" + tag + '\'' +
                ", color='" + color + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

}
