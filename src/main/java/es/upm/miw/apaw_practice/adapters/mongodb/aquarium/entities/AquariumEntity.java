package es.upm.miw.apaw_practice.adapters.mongodb.aquarium.entities;
import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.entities.ComputerEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class AquariumEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String description;
    private Double size;
    private Integer maximumFishCapacity;

    public AquariumEntity() {
        //empty for framework
    }

    public AquariumEntity(String description, Double size, Integer maximumFishCapacity) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.size = size;
        this.maximumFishCapacity = maximumFishCapacity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Integer getmaximumFishCapacity() {
        return maximumFishCapacity;
    }

    public void setmaximumFishCapacity(Integer maximumFishCapacity) {
        maximumFishCapacity = maximumFishCapacity;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AquariumEntity that)) return false;
        return (Objects.equals(getId(), that.getId()) || Objects.equals(getDescription(), that.getDescription()))
                && Objects.equals(size, that.size)
                && Objects.equals(maximumFishCapacity, that.maximumFishCapacity);
    }

    @Override
    public String toString() {
        return "AquariumEntity{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", size=" + size +
                ", maximumFishCapacity=" + maximumFishCapacity +
                '}';
    }
}