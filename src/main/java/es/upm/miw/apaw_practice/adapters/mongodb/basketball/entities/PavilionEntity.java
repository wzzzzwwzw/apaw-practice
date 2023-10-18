package es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities;
import es.upm.miw.apaw_practice.domain.models.basketball.Pavilion;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;
@Document
public class PavilionEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String pavname;
    private String direction;
    private Integer capacity;


    public PavilionEntity() {

    }

    public PavilionEntity(Pavilion pavilion) {
        BeanUtils.copyProperties(pavilion, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getPavname() {
        return pavname;
    }

    public void setPavname(String pavname) {
        this.pavname = pavname;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Pavilion toPavilion() {
        return new Pavilion(this.pavname, this.direction, this.capacity);
    }

    @Override
    public int hashCode() {
        return this.pavname.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (pavname.equals(((PavilionEntity) obj).pavname));
    }

    @Override
    public String toString() {
        return "PavilionEntity{" +
                "id='" + id + '\'' +
                ", pavname='" + pavname + '\'' +
                ", direction='" + direction + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
