package es.upm.miw.apaw_practice.adapters.mongodb.bakery.entities;

import es.upm.miw.apaw_practice.domain.models.bakery.Shelf;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
public class ShelfEntity {
    @Id
    private String id;
    private String name;
    private Integer maxCapacity;
    private Integer shelves;
    private String location;
    @DBRef
    private List<ProductEntity> products;

    public ShelfEntity() {
        // empty for framework
    }

    public ShelfEntity(String name, Integer maxCapacity, Integer shelves, String location,
            List<ProductEntity> products) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.shelves = shelves;
        this.location = location;
        this.products = products;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<ProductEntity> getProducts() {
        return this.products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public void fromShelf(Shelf shelf) {
        BeanUtils.copyProperties(shelf, this);
    }

    public Shelf toShelf() {
        Shelf shelf = new Shelf();
        BeanUtils.copyProperties(this, shelf);
        return shelf;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((ShelfEntity) obj).id));
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", maxCapacity='" + getMaxCapacity() + "'" +
                ", shelves='" + getShelves() + "'" +
                ", location='" + getLocation() + "'" +
                ", products='" + getProducts() + "'" +
                "}";
    }
}
