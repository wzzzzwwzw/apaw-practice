package es.upm.miw.apaw_practice.adapters.mongodb.bakery.entities;

import es.upm.miw.apaw_practice.domain.models.bakery.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Document
public class ProductEntity {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean glutenFree;
    private LocalDate expirationDate;
    @DBRef
    private ProductTypeEntity productType;

    public ProductEntity() {
        // empty for framework
    }

    public ProductEntity(String name, String description, BigDecimal price, Boolean glutenFree,
            LocalDate expirationDate, ProductTypeEntity productType) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.glutenFree = glutenFree;
        this.expirationDate = expirationDate;
        this.productType = productType;
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

    public ProductTypeEntity getProductType() {
        return this.productType;
    }

    public void setProductType(ProductTypeEntity productType) {
        this.productType = productType;
    }

    public void fromProduct(Product product) {
        BeanUtils.copyProperties(product, this);
    }

    public Product toProduct() {
        Product product = new Product();
        BeanUtils.copyProperties(this, product);
        return product;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((ProductEntity) obj).id));
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", description='" + getDescription() + "'" +
                ", price='" + getPrice() + "'" +
                ", glutenFree='" + isGlutenFree() + "'" +
                ", expirationDate='" + getExpirationDate() + "'" +
                ", productType='" + getProductType() + "'" +
                "}";
    }
}
