package es.upm.miw.apaw_practice.domain.models.football_competition;

import java.math.BigDecimal;

public class FootballTeam {
    private String city;
    private Integer foundationYear;
    private BigDecimal budget;

    private Boolean removed;

    public FootballTeam() {}

    public FootballTeam(String city, Integer foundationYear, BigDecimal budget) {
        this.city = city;
        this.foundationYear = foundationYear;
        this.budget = budget;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getFoundationYear() {
        return this.foundationYear;
    }

    public void setFoundationYear(Integer foundationYear) {
        this.foundationYear = foundationYear;
    }

    public BigDecimal getBudget() {
        return this.budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public Boolean isRemoved() {
        return this.removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    @Override
    public String toString() {
        return "FootballTeam{" +
                "City=" + this.city +
                ", Foundation Year=" + this.foundationYear +
                ", Budget=" + this.budget +
                '}';
    }
}
