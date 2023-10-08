package es.upm.miw.apaw_practice.domain.models.bakery;

import java.util.List;

public class Shelf {
    private String name;
    private Integer maxCapacity;
    private Integer shelves;
    private String location;
    private List<Product> products;

    public Shelf() {
        //empty for framework
    }

    public Shelf(String name, Integer maxCapacity, Integer shelves, String location, List<Product> products) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.shelves = shelves;
        this.location = location;
        this.products = products;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxCapacity() {
        return this.maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Integer getShelves() {
        return this.shelves;
    }

    public void setShelves(Integer shelves) {
        this.shelves = shelves;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", maxCapacity='" + getMaxCapacity() + "'" +
            ", shelves='" + getShelves() + "'" +
            ", location='" + getLocation() + "'" +
            ", products='" + getProducts() + "'" +
            "}";
    }
}
