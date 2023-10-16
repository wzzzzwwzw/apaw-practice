package es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities;

import es.upm.miw.apaw_practice.domain.models.hotel.HotelActivity;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelBooking;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.UUID;

public class HotelActivityEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String schedule;
    private String instructor;
    private Integer maxParticipants;

    public HotelActivityEntity() {
        // empty for framework
    }

    public HotelActivityEntity(HotelActivity activity) {
        BeanUtils.copyProperties(activity, this);
        this.id = UUID.randomUUID().toString();
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

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Integer getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(Integer maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public HotelActivity toObject() {
        HotelActivity activity = new HotelActivity();
        BeanUtils.copyProperties(this, activity);
        return activity;
    }
    @Override
    public String toString() {
        return "HotelActivity {" + '\'' +
                "  name = '" + name + '\'' +
                "  schedule = '" + schedule + '\'' +
                "  instructor = '" + instructor + '\'' +
                "  maxParticipants = " + maxParticipants + '\'' +
                '}';
    }
}
