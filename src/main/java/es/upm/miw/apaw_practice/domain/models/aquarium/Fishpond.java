package es.upm.miw.apaw_practice.domain.models.aquarium;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fishpond {
    private String direction;
    private Integer fishId;
    private LocalDate openTime;
    private List<Fish> fishes;


    public Fishpond(String direction, Integer fishId, LocalDate openTime, List<Fish> fishes) {
        this.direction = direction;
        this.fishId = fishId;
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
        return fishId;
    }

    public void setId(Integer fishId) {
        this.fishId = fishId;
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
                ", fishId=" + fishId +
                ", openTime=" + openTime +
                ", fishes=" + fishes +
                '}';
    }
}
