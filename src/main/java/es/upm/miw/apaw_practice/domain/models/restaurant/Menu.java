package es.upm.miw.apaw_practice.domain.models.restaurant;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Menu {

    private String id;
    private List<Dish> dishes;
    private LocalDateTime lastModification;

    public Menu() {
        //empty from framework
    }

    public Menu(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public LocalDateTime getLastModification() {
        return lastModification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return dishes.equals(menu.dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishes);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", dishes=" + dishes +
                ", lastModification=" + lastModification +
                '}';
    }

}
