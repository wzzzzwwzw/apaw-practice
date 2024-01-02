package es.upm.miw.apaw_practice.domain.models.subway;

import java.util.List;

public class Subway {

    private String city;
    private Boolean open24h;
    private Integer capacity;
    private List<Line> lines;

    public Subway(String city, Boolean open24h, Integer capacity, List<Line> lines) {
        this.city = city;
        this.open24h = open24h;
        this.capacity = capacity;
        this.lines = lines;
    }

    public Subway() {
        //for framework
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

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Line{" +
                "city='" + city + '\'' +
                ", open24h=" + open24h +
                ", capacity=" + capacity +
                ", lines=" + lines +
                '}';
    }
}