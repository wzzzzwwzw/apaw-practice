package es.upm.miw.apaw_practice.adapters.mongodb.computer_store.entities;

import es.upm.miw.apaw_practice.domain.models.computer_store.Monitor;
import es.upm.miw.apaw_practice.domain.models.computer_store.Wire;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class MonitorEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String serialNumber;
    private BigDecimal size;
    private Integer refreshRate;
    @DBRef
    private List<WireEntity> wireEntities;

    public MonitorEntity() {
        //empty for framework
    }

    public MonitorEntity(String serialNumber, BigDecimal size, Integer refreshRate, List<WireEntity> wireEntities) {
        this.id = UUID.randomUUID().toString();
        this.serialNumber = serialNumber;
        this.size = size;
        this.refreshRate = refreshRate;
        this.wireEntities = wireEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public Integer getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(Integer refreshRate) {
        this.refreshRate = refreshRate;
    }

    public List<WireEntity> getWireEntities() {
        return wireEntities;
    }

    public void setWireEntities(List<WireEntity> wireEntities) {
        this.wireEntities = wireEntities;
    }

    public Monitor toMonitor() {
        Monitor monitor = new Monitor();
        BeanUtils.copyProperties(this, monitor);
        List<Wire> wires = this.getWireEntities()
                .stream()
                .map(WireEntity::toWire)
                .toList();
        monitor.setWires(wires);
        return monitor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MonitorEntity that)) return false;
        return Objects.equals(id, that.id) || Objects.equals(serialNumber, that.serialNumber);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "MonitorEntity{" +
                "id='" + id + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", size=" + size +
                ", refreshRate=" + refreshRate +
                ", wires=" + wireEntities +
                '}';
    }
}
