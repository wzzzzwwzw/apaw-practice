package es.upm.miw.apaw_practice.domain.models.subway;

import java.time.LocalDateTime;

public class Schedule {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Float frequency;

    public Schedule(LocalDateTime startTime, LocalDateTime endTime, Float frequency) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.frequency = frequency;
    }

    public Schedule() {
        //for framework
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

    @java.lang.Override
    public java.lang.String toString() {
        return "Schedule{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", frequency=" + frequency +
                '}';
    }
}
