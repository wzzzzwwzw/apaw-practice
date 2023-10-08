package es.upm.miw.apaw_practice.domain.models.basketball;

class Pavilion {
    private String pavName;
    private String direction;
    private Integer capacity;

    public Pavilion(){

    }

    public Pavilion(String pavName, String direction, Integer capacity) {
        this.pavName = pavName;
        this.direction = direction;
        this.capacity = capacity;
    }

    public String getPavName() {
        return pavName;
    }

    public void setPavName(String pavName) {
        this.pavName = pavName;
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
                "pavName='" + pavName + '\'' +
                ", direction='" + direction + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}