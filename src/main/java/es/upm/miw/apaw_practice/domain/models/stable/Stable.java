package es.upm.miw.apaw_practice.domain.models.stable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Stable {
    private String name;
    private String address;
    private int maxCapacity;
    private LocalDate foundationDate;
    private List<Horse> horses;

    public Stable(String name, String address, int maxCapacity, LocalDate foundationDate) {
        this.name = name;
        this.address = address;
        this.maxCapacity = maxCapacity;
        this.foundationDate = foundationDate;
        this.horses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }

    public void addHorse(Horse horse) {
        horses.add(horse);
    }

    public void removeHorse(Horse horse) {
        horses.remove(horse);
    }
}