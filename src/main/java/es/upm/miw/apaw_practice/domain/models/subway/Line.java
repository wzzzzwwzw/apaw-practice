package es.upm.miw.apaw_practice.domain.models.subway;

import es.upm.miw.apaw_practice.domain.models.subway.builders.LineBuilders;
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

    public Boolean getWorking() {
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

    public static class Builder implements LineBuilders.Label, LineBuilders.Optionals{

        private final Line line;

        public Builder() {
            this.line = new Line();
        }

        @Override
        public LineBuilders.Optionals label(String label) {
            this.line.setLabel(label);
            return this;
        }

        @Override
        public LineBuilders.Optionals color(String color) {
            this.line.setColor(color);
            return this;
        }

        @Override
        public LineBuilders.Optionals works(Boolean works) {
            this.line.setWorks(works);
            return this;
        }

        @Override
        public LineBuilders.Optionals schedule(Schedule schedule) {
            this.line.setSchedule(schedule);
            return this;
        }

        @Override
        public LineBuilders.Optionals stations(List<Station> stations) {
            this.line.setStations(stations);
            return this;
        }

        public Line build() {
            return this.line;
        }
    }

}
