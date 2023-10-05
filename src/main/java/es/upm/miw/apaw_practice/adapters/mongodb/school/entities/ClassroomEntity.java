package es.upm.miw.apaw_practice.adapters.mongodb.school.entities;

import es.upm.miw.apaw_practice.domain.models.school.Classroom;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document
public class ClassroomEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String location;
    private LocalDateTime entryHour;
    private Boolean smartBoard;
    private Integer lockers;

    public ClassroomEntity() {
        //empty from framework
    }

    public ClassroomEntity(Classroom classroom) {
        BeanUtils.copyProperties(classroom, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getEntryHour() {
        return entryHour;
    }

    public void setEntryHour(LocalDateTime entryHour) {
        this.entryHour = entryHour;
    }

    public Boolean getSmartBoard() {
        return smartBoard;
    }

    public void setSmartBoard(Boolean smartBoard) {
        this.smartBoard = smartBoard;
    }

    public Integer getLockers() {
        return lockers;
    }

    public void setLockers(Integer lockers) {
        this.lockers = lockers;
    }

    public Classroom toClassroom() {
        Classroom classroom = new Classroom();
        BeanUtils.copyProperties(this, classroom);
        return classroom;
    }

    @Override
    public int hashCode() {
        return location.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (location.equals(((ClassroomEntity) obj).location));
    }

    @Override
    public String toString() {
        return "ClassroomEntity{" +
                "id='" + id + '\'' +
                ", location='" + location + '\'' +
                ", entryHour=" + entryHour +
                ", smartBoard=" + smartBoard +
                ", lockers=" + lockers +
                '}';
    }
}
