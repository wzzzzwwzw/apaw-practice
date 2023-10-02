package es.upm.miw.apaw_practice.domain.models.subway;

import java.util.List;

public class Subway {

    private String city;
    private Boolean open24h;
    private Int capacity;
    private List<Line> lines;

    public Line(String city, Boolean open24h, Int capacity) {
        this.city = city;
        this.open24h = open24h;
        this.capacity = capacity;
        this.lines = new ArrayList<Lines>;
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

    public Int getCapacity() {
        return capacity;
    }

    public void setCapacity(Int capacity) {
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