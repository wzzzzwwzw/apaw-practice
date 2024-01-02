package es.upm.miw.apaw_practice.adapters.mongodb.subway.entities;

import es.upm.miw.apaw_practice.domain.models.subway.Schedule;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Document
public class ScheduleEntity {

    @Id
    private String id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Float frequency;

    public ScheduleEntity(Schedule schedule) {
        this.id = UUID.randomUUID().toString();
        BeanUtils.copyProperties(schedule, this);
    }

    public ScheduleEntity() {
        //for framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Float getFrequency() {
        return frequency;
    }

    public void setFrequency(Float frequency) {
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleEntity that = (ScheduleEntity) o;
        return Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(frequency, that.frequency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startTime, endTime, frequency);
    }

    public Schedule toSchedule() {
        Schedule schedule = new Schedule();
        BeanUtils.copyProperties(this, schedule);
        return schedule;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Schedule{" +
                "id='" + id + '\'' +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", frequency=" + frequency +
                '}';
    }

}
