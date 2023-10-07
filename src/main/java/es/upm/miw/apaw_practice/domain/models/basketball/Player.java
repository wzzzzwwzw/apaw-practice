package es.upm.miw.apaw_practice.domain.models.basketball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private String position;
    private Integer age;
    private List<Basket> baskets;

    public Player(String name, String position, Integer age) {
        this.name = name;
        this.position = position;
        this.age = age;
    }

    public Player() {
        this.baskets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public Integer getAge() {
        return age;
    }

    public List<Basket> getBaskets() {
        return baskets;
    }

    public void addBasket(Basket basket) {
        this.baskets.add(basket);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBaskets(List<Basket> baskets) {
        this.baskets = baskets;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", position=" + position +
                '}';
    }
}

