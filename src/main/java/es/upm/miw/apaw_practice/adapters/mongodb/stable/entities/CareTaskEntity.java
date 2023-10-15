package es.upm.miw.apaw_practice.adapters.mongodb.stable.entities;

import es.upm.miw.apaw_practice.domain.models.stable.CareTask;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class CareTaskEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String description;
    private Double durationHours;

    public CareTaskEntity() {
        //Empty from framework
    }

    public CareTaskEntity(CareTask careTask) {
        BeanUtils.copyProperties(careTask, this);
        this.id = UUID.randomUUID().toString();
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

    public Double getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(Double durationHours) {
        this.durationHours = durationHours;
    }
    public CareTask toCareTask() {
        CareTask careTask = new CareTask();
        BeanUtils.copyProperties(this, careTask);
        return careTask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CareTaskEntity that = (CareTaskEntity) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    @Override
    public String toString() {
        return "CareTaskEntity{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", durationHours=" + durationHours +
                '}';
    }
}
