package es.upm.miw.apaw_practice.domain.models.subway;

import es.upm.miw.apaw_practice.domain.models.subway.builders.StationBuilders;

public class Station {
    private String name;
    private String order;
    private Boolean open;

    public Station(String name, String order, Boolean open) {
        this.name = name;
        this.order = order;
        this.open = open;
    }

    public Station() {
        //for framework
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", order='" + order + '\'' +
                ", open=" + open +
                '}';
    }

    public static class Builder implements StationBuilders.Name, StationBuilders.Optionals {

        private final Station station;

        public Builder() {
            this.station = new Station();
        }

        @Override
        public StationBuilders.Optionals name(String name) {
            this.station.setName(name);
            return this;
        }

        @Override
        public StationBuilders.Optionals order(String order) {
            this.station.setOrder(order);
            return this;
        }

        @Override
        public StationBuilders.Optionals open(Boolean open) {
            this.station.setOpen(open);
            return this;
        }

        @Override
        public Station build() {
            return this.station;
        }
    }

}