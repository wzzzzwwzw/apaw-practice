package es.upm.miw.apaw_practice.adapters.mongodb.aquarium.entities;
import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.entities.ComputerEntity;
import es.upm.miw.apaw_practice.domain.models.aquarium.Aquarium;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.beans.BeanUtils;
import es.upm.miw.apaw_practice.domain.models.aquarium.Aquarium;

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

    public Integer getMaximumFishCapacity() {
        return maximumFishCapacity;
    }

    public void setMaximumFishCapacity(Integer maximumFishCapacity) {
        this.maximumFishCapacity = maximumFishCapacity;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AquariumEntity that = (AquariumEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description) && Objects.equals(size, that.size) && Objects.equals(maximumFishCapacity, that.maximumFishCapacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, size, maximumFishCapacity);
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

    public Aquarium toAquarium() {
        Aquarium aquarium = new Aquarium();
        BeanUtils.copyProperties(this,aquarium);
        return aquarium;
    }
    public AquariumEntity(Aquarium aquarium) {
        BeanUtils.copyProperties(aquarium, this);
        this.id = UUID.randomUUID().toString();
    }
}