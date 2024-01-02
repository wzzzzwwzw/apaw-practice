package es.upm.miw.apaw_practice.adapters.mongodb.subway.entities;

import es.upm.miw.apaw_practice.domain.models.subway.Line;
import es.upm.miw.apaw_practice.domain.models.subway.Station;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class LineEntity {

    @Id
    private String id;

    @Indexed(unique = true)

    private String label;
    private String color;
    private Boolean works;

    @DBRef
    private List<StationEntity> stations;
    @DBRef
    private ScheduleEntity schedule;


    public LineEntity(String label, String color, Boolean works, ScheduleEntity schedule, List<StationEntity> stations) {
        this.id = UUID.randomUUID().toString();
        this.label = label;
        this.color = color;
        this.works = works;
        this.stations = stations;
        this.schedule = schedule;
    }

    public LineEntity() {
        //for framework
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean isWorking() {
        return works;
    }

    public void setWorks(Boolean works) {
        this.works = works;
    }

    public List<StationEntity> getStations() {
        return stations;
    }

    public void setStations(List<StationEntity> stations) {
        this.stations = stations;
    }

    public ScheduleEntity getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleEntity schedule) {
        this.schedule = schedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineEntity that = (LineEntity) o;
        return Objects.equals(label, that.label) && Objects.equals(color, that.color) && Objects.equals(works, that.works) && Objects.equals(stations, that.stations) && Objects.equals(schedule, that.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, color, works, stations, schedule);
    }

    public Line toLine() {
        List<Station> stationsCollection = this.stations.stream()
                .map(StationEntity::toStation)
                .toList();
        return new Line(this.label, this.color, this.works, this.schedule.toSchedule(), stationsCollection);
    }

    @Override
    public String toString() {
        return "Line{" +
                "id='" + id + '\'' +
                "label='" + label + '\'' +
                ", color='" + color + '\'' +
                ", works=" + works +
                ", stations=" + stations +
                '}';
    }
}
