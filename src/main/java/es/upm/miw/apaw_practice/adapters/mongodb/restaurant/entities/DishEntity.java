package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class DishEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String title;
    private BigDecimal price;
    @DBRef
    private CategoryRestaurantEntity category;
    @DBRef
    private List<IngredientEntity> ingredients;

    public DishEntity() {
        //empty from framework
    }

    public DishEntity(String title, BigDecimal price, CategoryRestaurantEntity category, List<IngredientEntity> ingredients) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.price = price;
        this.category = category;
        this.ingredients = ingredients;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryRestaurantEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryRestaurantEntity category) {
        this.category = category;
    }

    public List<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishEntity that = (DishEntity) o;
        return Objects.equals(title, that.title) && Objects.equals(price, that.price) && Objects.equals(category, that.category) && Objects.equals(ingredients, that.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, category, ingredients);
    }

    @Override
    public String toString() {
        return "DishEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", ingredients=" + ingredients +
                '}';
    }

}
