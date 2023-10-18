package es.upm.miw.apaw_practice.domain.models.basketball;

public class Pavilion {
    private String pavname;
    private String direction;
    private Integer capacity;

    public Pavilion(){

    }

    public Pavilion(String pavname, String direction, Integer capacity) {
        this.pavname = pavname;
        this.direction = direction;
        this.capacity = capacity;
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
}