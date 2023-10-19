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

    // Builder Pattern

    public static ProductBuilder.Name builder(String name) {
        return new Product.Builder();
    }

    private interface ProductBuilder {
        interface Name {
            Description name(String name);
        }

        interface Description {
            Price description(String description);
        }

        interface Price {
            GlutenFree price(BigDecimal price);
        }

        interface GlutenFree {
            ExpirationDate isGlutenFree(Boolean isGlutenFree);
        }

        interface ExpirationDate {
            ProductType expirationDate(LocalDate date);
        }

        interface ProductType {
            ProductType productType(es.upm.miw.apaw_practice.domain.models.bakery.ProductType productType);

            Product build();
        }
    }

    public static class Builder implements ProductBuilder.Name, ProductBuilder.Description, ProductBuilder.Price,
            ProductBuilder.GlutenFree, ProductBuilder.ExpirationDate, ProductBuilder.ProductType {
        private final Product product;

        public Builder() {
            this.product = new Product();
        }

        @Override
        public ProductBuilder.Description name(String name) {
            this.product.setName(name);
            return this;
        }

        @Override
        public ProductBuilder.Price description(String description) {
            this.product.setDescription(description);
            return this;
        }

        @Override
        public ProductBuilder.GlutenFree price(BigDecimal price) {
            this.product.setPrice(price);
            return this;
        }

        @Override
        public ProductBuilder.ExpirationDate isGlutenFree(Boolean glutenFree) {
            this.product.setGlutenFree(glutenFree);
            return this;
        }

        @Override
        public ProductBuilder.ProductType expirationDate(LocalDate date) {
            this.product.setExpirationDate(date);
            return this;
        }

        @Override
        public Product build() {
            return this.product;
        }

        @Override
        public ProductBuilder.ProductType productType(
                es.upm.miw.apaw_practice.domain.models.bakery.ProductType productType) {
            this.product.setProductType(productType);
            return this;
        }
    }
}
