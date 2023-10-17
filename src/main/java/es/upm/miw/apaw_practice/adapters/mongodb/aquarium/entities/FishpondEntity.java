package es.upm.miw.apaw_practice.adapters.mongodb.aquarium.entities;
import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.entities.ComputerEntity;
import es.upm.miw.apaw_practice.domain.models.aquarium.Fish;
import es.upm.miw.apaw_practice.domain.models.aquarium.Fishpond;
import es.upm.miw.apaw_practice.domain.models.aquarium.Aquarium;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
@Document
public class FishpondEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String direction;
    private Integer fishId;
    private LocalDate openTime;
    private List<FishEntity> fishEntities;

    public FishpondEntity() {
        //empty for framework
    }

    public FishpondEntity(String direction, Integer fishId, LocalDate openTime, List<FishEntity> fishEntities) {
        this.id = UUID.randomUUID().toString();
        this.direction = direction;
        this.fishId = fishId;
        this.openTime = openTime;
        this.fishEntities = fishEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getFishId() {
        return fishId;
    }

    public void setFishId(Integer fishId) {
        this.fishId = fishId;
    }

    public LocalDate getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalDate openTime) {
        this.openTime = openTime;
    }

    public List<FishEntity> getFishEntities() {
        return fishEntities;
    }

    public void setFishEntities(List<FishEntity> fishEntities) {
        this.fishEntities = fishEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FishpondEntity that)) return false;
        return (Objects.equals(getId(), that.getId()) || Objects.equals(getDirection(), that.getDirection()))
                && Objects.equals(getFishEntities(), that.getFishEntities());
    }
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "FishpondEntity{" +
                "id='" + id + '\'' +
                ", direction='" + direction + '\'' +
                ", fishId=" + fishId +
                ", openTime=" + openTime +
                ", fishes=" + fishEntities +
                '}';
    }
}
