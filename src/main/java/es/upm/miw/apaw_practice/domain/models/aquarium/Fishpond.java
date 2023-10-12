package es.upm.miw.apaw_practice.domain.models.aquarium;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fishpond {
    private String direction;
    private Integer id;
    private LocalDate openTime;
    private List<Fish> fishes;


    public Fishpond(String direction, Integer id, LocalDate openTime, List<Fish> fishes) {
        this.direction = direction;
        this.id = id;
        this.openTime = openTime;
        this.fishes = fishes;
    }
    public Fishpond()
    {fishes = new ArrayList<>();}

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalDate openTime) {
        this.openTime = openTime;
    }

    public List<Fish> getFish() {
        return fishes;
    }

    public void setFish(List<Fish> fishes) {
        this.fishes = fishes;
    }

    @Override
    public String toString() {
        return "Fishpond{" +
                "direction='" + direction + '\'' +
                ", id=" + id +
                ", openTime=" + openTime +
                ", fishes=" + fishes +
                '}';
    }
}
