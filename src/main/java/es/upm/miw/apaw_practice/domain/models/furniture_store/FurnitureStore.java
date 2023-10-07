package es.upm.miw.apaw_practice.domain.models.furniture_store;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FurnitureStore {
    private String name;
    private LocalDateTime openingTime;
    private LocalDateTime closeTime;
    private Manager manager;
    private List<Furniture> furnitures;

    public FurnitureStore() {
        //empty from framework
    }

    public FurnitureStore(String name, LocalDateTime openingTime,
                          LocalDateTime closeTime, Manager manager) {
        this.name = name;
        this.openingTime = openingTime;
        this.closeTime = closeTime;
        this.manager = manager;
        this.furnitures = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalDateTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalDateTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalDateTime closeTime) {
        this.closeTime = closeTime;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Furniture> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(List<Furniture> furnitures) {
        this.furnitures = furnitures;
    }

    @Override
    public String toString() {
        return "FurnitureStore{" +
                "name='" + name + '\'' +
                ", openingTime=" + openingTime +
                ", closeTime=" + closeTime +
                ", manager=" + manager +
                ", furnitures=" + furnitures +
                '}';
    }
}
