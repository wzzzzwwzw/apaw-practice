package es.upm.miw.apaw_practice.domain.models.subway;

import java.util.List;

public class Line {
    private String label;
    private String color;
    private boolean works;
    private List<Station> stations;
    private Schedule schedule;


    public Line(String label, String color, boolean works, Schedule schedule) {
        this.label = label;
        this.color = color;
        this.works = works;
        this.stations = new ArrayList<Station>;
        this.schedule = schedule;
    }

    public Line() {
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

    public boolean isWorking() {
        return works;
    }

    public void setWorks(boolean works) {
        this.works = works;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Line{" +
                "label='" + label + '\'' +
                ", color='" + color + '\'' +
                ", works=" + works +
                ", stations=" + stations +
                '}';
    }
}

