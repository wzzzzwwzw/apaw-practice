package es.upm.miw.apaw_practice.domain.models.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.builders.CategoryRestaurantBuilders;

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

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryRestaurant that = (CategoryRestaurant) o;
        return tag.equals(that.tag) && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag, color);
    }

    @Override
    public String toString() {
        return "CategoryRestaurant{" +
                "tag='" + tag + '\'' +
                ", color='" + color + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }


    public static class Builder implements CategoryRestaurantBuilders.Tag, CategoryRestaurantBuilders.Optionals {
        private final CategoryRestaurant category;

        public Builder() {
            category = new CategoryRestaurant();
        }


        @Override
        public CategoryRestaurantBuilders.Optionals tag(String tag) {
            this.category.tag = tag;
            return this;
        }

        @Override
        public CategoryRestaurantBuilders.Optionals color(String color) {
            this.category.color = color;
            return this;
        }

        @Override
        public CategoryRestaurantBuilders.Optionals creationDate(LocalDateTime creationDate) {
            this.category.creationDate = creationDate;
            return this;
        }

        @Override
        public CategoryRestaurant build() {
            return this.category;
        }
    }


}
