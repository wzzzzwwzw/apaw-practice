package es.upm.miw.apaw_practice.domain.models.basketball;

import es.upm.miw.apaw_practice.domain.models.basketball.builders.PavilionBuilders;

public class Pavilion {
    private String pavname;
    private String direction;
    private Integer capacity;

    public Pavilion(){
        // empty for framework
    }

    public static PavilionBuilders.Pavname builder() {
        return new Builder();
    }
    public String getPavname() {
        return pavname;
    }

    public void setPavname(String pavname) {
        this.pavname = pavname;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    @Override
    public String toString() {
        return "Pavilion{" +
                "pavname='" + pavname + '\'' +
                ", direction='" + direction + '\'' +
                ", capacity=" + capacity +
                '}';
    }


    public static class Builder implements PavilionBuilders.Pavname, PavilionBuilders.Direction, PavilionBuilders.Capacity {
        private final Pavilion pavilion;

        public Builder() {
            this.pavilion = new Pavilion();
        }

        @Override
        public PavilionBuilders.Direction pavname(String pavname) {
            this.pavilion.setPavname(pavname);
            return this;
        }

        @Override
        public PavilionBuilders.Capacity direction(String direction) {
            this.pavilion.setDirection(direction);
            return this;
        }

        @Override
        public Pavilion build() {
            return this.pavilion;
        }

        @Override
        public PavilionBuilders.Capacity capacity(int i) {
            this.pavilion.setCapacity(i);
            return this;
        }
    }
}