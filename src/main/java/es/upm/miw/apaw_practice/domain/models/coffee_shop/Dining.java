package es.upm.miw.apaw_practice.domain.models.coffee_shop;


public class Dining {
    private String diningNumber;
    private String location;
    private Integer capacity;

    public Dining() {
    }

    public Dining(String diningNumber, String location, Integer capacity) {
        this.diningNumber = diningNumber;
        this.location = location;
        this.capacity = capacity;
    }

    public String getDiningNumber() {
        return diningNumber;
    }

    public void setDiningNumber(String diningNumber) {
        this.diningNumber = diningNumber;
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
                "diningNumber='" + diningNumber + '\'' +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
