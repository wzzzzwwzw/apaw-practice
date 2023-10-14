package es.upm.miw.apaw_practice.adapters.mongodb.bakery.entities;

import es.upm.miw.apaw_practice.domain.models.bakery.ProductType;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class ProductTypeEntity {
    @Id
    private String id;
    private String name;
    private String description;
    private String code;

    public ProductTypeEntity() {
        // empty for framework
    }

    public ProductTypeEntity(ProductType productType) {
        BeanUtils.copyProperties(productType, this);
        this.id = UUID.randomUUID().toString();
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

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void fromProductType(ProductType productType) {
        BeanUtils.copyProperties(productType, this);
    }

    public ProductType toProductType() {
        ProductType productType = new ProductType();
        BeanUtils.copyProperties(this, productType);
        return productType;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((ProductTypeEntity) obj).id));
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", description='" + getDescription() + "'" +
                ", code='" + getCode() + "'" +
                "}";
    }
}
