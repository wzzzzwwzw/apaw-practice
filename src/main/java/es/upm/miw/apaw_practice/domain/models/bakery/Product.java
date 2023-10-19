package es.upm.miw.apaw_practice.domain.models.bakery;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Product {
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean glutenFree;
    private LocalDate expirationDate;
    private ProductType productType;
    private Shelf shelf;

    public Product() {
        // empty for framework
    }

    public Product(String name, String description, BigDecimal price, Boolean glutenFree, LocalDate expirationDate,
            ProductType productType, Shelf shelf) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.glutenFree = glutenFree;
        this.expirationDate = expirationDate;
        this.productType = productType;
        this.shelf = shelf;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean isGlutenFree() {
        return this.glutenFree;
    }

    public Boolean getGlutenFree() {
        return this.glutenFree;
    }

    public void setGlutenFree(Boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public LocalDate getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public ProductType getProductType() {
        return this.productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Shelf getShelf() {
        return this.shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", description='" + getDescription() + "'" +
                ", price='" + getPrice() + "'" +
                ", glutenFree='" + isGlutenFree() + "'" +
                ", expirationDate='" + getExpirationDate() + "'" +
                ", productType='" + getProductType() + "'" +
                "}";
    }
}
