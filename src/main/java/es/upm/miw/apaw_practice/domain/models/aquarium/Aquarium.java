package es.upm.miw.apaw_practice.domain.models.aquarium;


public class Aquarium {
    private String description;
    private Double size;
    private Integer maximumFishCapacity;

    public Aquarium(String description, Double size, Integer maximumFishCapacity) {
        this.description = description;
        this.size = size;
        maximumFishCapacity = maximumFishCapacity;
    }
    public Aquarium(){
        //empty for framework
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Integer getMaximumFishCapacity() {
        return maximumFishCapacity;
    }

    public void setMaximumFishCapacity(Integer maximumFishCapacity) {
        maximumFishCapacity = maximumFishCapacity;
    }

    @Override
    public String toString() {
        return "Aquaruim{" +
                "description='" + description + '\'' +
                ", size=" + size +
                ", MaximumFishCapacity=" + maximumFishCapacity +
                '}';
    }
}
