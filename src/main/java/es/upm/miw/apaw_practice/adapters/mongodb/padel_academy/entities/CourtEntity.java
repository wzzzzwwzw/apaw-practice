package es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.entities;

import java.util.Objects;

public class CourtEntity {
    private Integer number;
    private Boolean withRoof;
    private String surface;

    public CourtEntity() {
        // Empty for framework
    }

    public CourtEntity(Integer number, Boolean withRoof, String surface) {
        this.number = number;
        this.withRoof = withRoof;
        this.surface = surface;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getWithRoof() {
        return withRoof;
    }

    public void setWithRoof(Boolean withRoof) {
        this.withRoof = withRoof;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourtEntity that = (CourtEntity) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "CourtEntity{" +
                "number=" + number +
                ", withRoof=" + withRoof +
                ", surface='" + surface + '\'' +
                '}';
    }
}
