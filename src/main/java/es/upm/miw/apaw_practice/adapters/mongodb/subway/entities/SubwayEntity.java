package es.upm.miw.apaw_practice.adapters.mongodb.subway.entities;

import es.upm.miw.apaw_practice.domain.models.subway.Line;
import es.upm.miw.apaw_practice.domain.models.subway.Subway;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class SubwayEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String city;
    private Boolean open24h;
    private Integer capacity;
    private List<LineEntity> lines;

    public SubwayEntity(String city, Boolean open24h, Integer capacity, List<LineEntity> lines) {
        this.id = UUID.randomUUID().toString();
        this.city = city;
        this.open24h = open24h;
        this.capacity = capacity;
        this.lines = lines;
    }

    public SubwayEntity() {
        //for framework
    }

    public String getId() {
        return id;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getOpen24h() {
        return open24h;
    }

    public void setOpen24h(Boolean open24h) {
        this.open24h = open24h;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<LineEntity> getLines() {
        return lines;
    }

    public void setLines(List<LineEntity> lines) {
        this.lines = lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubwayEntity that = (SubwayEntity) o;
        return Objects.equals(city, that.city) && Objects.equals(open24h, that.open24h) && Objects.equals(capacity, that.capacity) && Objects.equals(lines, that.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, open24h, capacity, lines);
    }

    public Subway toSubway() {
        Subway subway = new Subway();
        BeanUtils.copyProperties(this, subway, "linesItemEntities");
        List<Line> linesCollection = this.lines.stream()
                .map(LineEntity::toLine)
                .toList();
        subway.setLines(linesCollection);
        return subway;

    }

    @Override
    public String toString() {
        return "SubwayEntity{" +
                "id='" + id + '\'' +
                ", city='" + city + '\'' +
                ", open24h=" + open24h +
                ", capacity=" + capacity +
                ", lines=" + lines +
                '}';
    }
}
