package es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.entities;

import es.upm.miw.apaw_practice.domain.models.coffee_shop.Dining;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;
@Document

public class DiningEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String diningNumber;
    private String location;
    private Integer capacity;

    public DiningEntity() {
        //empty from framework
    }

    public DiningEntity(Dining dining) {
        this.id = UUID.randomUUID().toString();
        BeanUtils.copyProperties(dining, this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDiningNumber() {
        return diningNumber;
    }

    public void setDiningNumber(String diningNumber) {
        this.diningNumber = diningNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void fromDining(Dining dining) {
        BeanUtils.copyProperties(dining, this);
    }

    public Dining toDining() {
        Dining dining = new Dining();
        BeanUtils.copyProperties(this, dining);
        return dining;
    }
    @Override
    public String toString() {
        return "DiningEntity{" +
                "id='" + id + '\'' +
                ", diningNumber='" + diningNumber + '\'' +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiningEntity that = (DiningEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(diningNumber, that.diningNumber) && Objects.equals(location, that.location) && Objects.equals(capacity, that.capacity);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
