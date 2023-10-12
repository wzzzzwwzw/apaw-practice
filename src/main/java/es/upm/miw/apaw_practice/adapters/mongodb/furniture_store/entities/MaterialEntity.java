package es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.entities;

import es.upm.miw.apaw_practice.domain.models.furniture_store.Material;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class MaterialEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String type;
    private Integer durability;

    public MaterialEntity() {
        //empty from framework
    }

    public MaterialEntity(Material material) {
        BeanUtils.copyProperties(material, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDurability() {
        return durability;
    }

    public void setDurability(Integer durability) {
        this.durability = durability;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (name.equals(((MaterialEntity) obj).name));
    }

    @Override
    public String toString() {
        return "Material{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", durability=" + durability +
                '}';
    }

}
