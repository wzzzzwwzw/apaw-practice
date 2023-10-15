package es.upm.miw.apaw_practice.adapters.mongodb.stable.entities;

import es.upm.miw.apaw_practice.domain.models.stable.Horse;
import es.upm.miw.apaw_practice.domain.models.stable.Stable;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Document
public class StableEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String address;
    private Integer maxCapacity;
    private LocalDate foundationDate;
    private List<HorseEntity> horseEntities;

    public StableEntity() {
        //empty from framework
    }

    public StableEntity(String name, String address, Integer maxCapacity, LocalDate foundationDate, List<HorseEntity> horseEntities) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.maxCapacity = maxCapacity;
        this.foundationDate = foundationDate;
        this.horseEntities = horseEntities;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    public List<HorseEntity> getHorseEntities() {
        return horseEntities;
    }

    public void setHorseEntities(List<HorseEntity> horseEntities) {
        this.horseEntities = horseEntities;
    }

    public Stable toStable() {
        Stable stable = new Stable();
        BeanUtils.copyProperties(this, stable);
        List<Horse> horses = this.horseEntities.stream()
                .map(HorseEntity::toHorse)
                .toList();
        stable.setHorses(horses);
        return stable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StableEntity that = (StableEntity) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "StableEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", foundationDate=" + foundationDate +
                ", horseEntities=" + horseEntities +
                '}';
    }
}
