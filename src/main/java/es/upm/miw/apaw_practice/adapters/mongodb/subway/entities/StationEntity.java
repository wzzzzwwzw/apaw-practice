package es.upm.miw.apaw_practice.adapters.mongodb.subway.entities;

import es.upm.miw.apaw_practice.domain.models.subway.Station;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class StationEntity {

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;
    private String order;
    private Boolean open;

    public StationEntity(Station station) {
        this.id = UUID.randomUUID().toString();
        BeanUtils.copyProperties(station, this);
    }

    public StationEntity() {
        //for framework
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

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Boolean isOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationEntity that = (StationEntity) o;
        return Objects.equals(name, that.name) && Objects.equals(order, that.order) && Objects.equals(open, that.open);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, order, open);
    }

    public Station toStation() {
        Station station = new Station();
        BeanUtils.copyProperties(this, station);
        return station;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Station{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", order='" + order + '\'' +
                ", open=" + open +
                '}';
    }
}
