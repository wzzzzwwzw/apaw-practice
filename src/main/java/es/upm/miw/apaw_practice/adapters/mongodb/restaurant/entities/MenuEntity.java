package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities;

import es.upm.miw.apaw_practice.domain.models.restaurant.Dish;
import es.upm.miw.apaw_practice.domain.models.restaurant.Menu;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class MenuEntity {

    @Id
    private String id;
    @DBRef
    private List<DishEntity> dishes;
    private LocalDateTime lastModification;

    public MenuEntity() {
        //empty from framework
    }

    public MenuEntity(List<DishEntity> dishes, LocalDateTime lastModification) {
        this.id = UUID.randomUUID().toString();
        this.dishes = dishes;
        this.lastModification = lastModification;
    }

    public String getId() {
        return id;
    }

    public List<DishEntity> getDishes() {
        return dishes;
    }

    public void setDishes(List<DishEntity> dishes) {
        this.dishes = dishes;
    }

    public LocalDateTime getLastModification() {
        return lastModification;
    }

    public Menu toMenu() {
        List<Dish> dishes = this.dishes.stream()
                .map(DishEntity::toDish).toList();
        return new Menu(dishes, lastModification);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuEntity that = (MenuEntity) o;
        return dishes.equals(that.dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishes);
    }

    @Override
    public String toString() {
        return "MenuEntity{" +
                "id='" + id + '\'' +
                ", dishes=" + dishes +
                ", lastModification=" + lastModification +
                '}';
    }

}
