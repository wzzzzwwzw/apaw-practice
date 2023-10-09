package es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class FurnitureEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private BigDecimal price;
    @DBRef
    private List<MaterialEntity> materialEntities;

    public FurnitureEntity() {
        //empty from framework
    }

    public FurnitureEntity(String name, BigDecimal price, List<MaterialEntity> materialEntities) {
        this.name = name;
        this.price = price;
        this.materialEntities = materialEntities;
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<MaterialEntity> getMaterialEntities() {
        return materialEntities;
    }

    public void setMaterialEntities(List<MaterialEntity> materialEntities) {
        this.materialEntities = materialEntities;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass()
                && (name.equals(((FurnitureEntity) obj).name));
    }

    @Override
    public String toString() {
        return "FurnitureEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", materialEntities=" + materialEntities +
                '}';
    }
}
