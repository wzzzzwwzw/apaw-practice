package es.upm.miw.apaw_practice.domain.models.subway;

import es.upm.miw.apaw_practice.domain.models.subway.trees.TreeLines;

import java.util.List;

public class Line implements TreeLines {
    private String label;
    private String color;
    private Boolean works;
    private List<Station> stations;
    private Schedule schedule;

    public Line(String label, String color, Boolean works, Schedule schedule, List<Station> stations) {
        this.label = label;
        this.color = color;
        this.works = works;
        this.stations = stations;
        this.schedule = schedule;
    }

    public Line() {
        // for framework
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
    public Boolean isComposite() {
        return false;
    }

    @Override
    public void add(TreeLines treeLines) {
        throw new UnsupportedOperationException("Unsupported operation in line leaf");
    }

    @Override
    public void remove(TreeLines treeLines) {
        // cannot remove in leaf
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
