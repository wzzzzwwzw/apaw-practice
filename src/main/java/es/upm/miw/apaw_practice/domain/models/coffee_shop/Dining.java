package es.upm.miw.apaw_practice.domain.models.coffee_shop;


public class Dining {
    private String location;
    private Integer capacity;

    public Dining() {
    }

    public Dining(String location, Integer capacity) {
        this.location = location;
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Dining{" +
                "location='" + location + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
