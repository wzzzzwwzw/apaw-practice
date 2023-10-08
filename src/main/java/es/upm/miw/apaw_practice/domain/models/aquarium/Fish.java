package es.upm.miw.apaw_practice.domain.models.aquarium;

import java.time.LocalDate;

public class Fish {
    private String species;
    private String color;
    private LocalDate dateOfEntrance;

    public Fish(String species, String color, LocalDate dateOfEntrance) {
        this.species = species;
        this.color = color;
        this.dateOfEntrance = dateOfEntrance;
    }
    public Fish(){
        //empty for framework
    }
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getDateOfEntrance() {
        return dateOfEntrance;
    }

    public void setDateOfEntrance(LocalDate dateOfEntrance) {
        this.dateOfEntrance = dateOfEntrance;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "species='" + species + '\'' +
                ", color='" + color + '\'' +
                ", dateOfEntrance=" + dateOfEntrance +
                '}';
    }
}
