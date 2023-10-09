package es.upm.miw.apaw_practice.adapters.mongodb.computer_store.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class ComputerEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private BigDecimal cost;
    private BigDecimal weight;
    private List<MonitorEntity> monitorEntities;

    public ComputerEntity() {
        //empty for framework
    }

    public ComputerEntity(String name, BigDecimal cost, BigDecimal weight, List<MonitorEntity> monitorEntities) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.cost = cost;
        this.weight = weight;
        this.monitorEntities = monitorEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public List<MonitorEntity> getMonitorEntities() {
        return monitorEntities;
    }

    public void setMonitorEntities(List<MonitorEntity> monitorEntities) {
        this.monitorEntities = monitorEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComputerEntity that)) return false;
        return (Objects.equals(getId(), that.getId()) || Objects.equals(getName(), that.getName()))
                && Objects.equals(getMonitorEntities(), that.getMonitorEntities());
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "ComputerEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", weight=" + weight +
                ", monitors=" + monitorEntities +
                '}';
    }
}
