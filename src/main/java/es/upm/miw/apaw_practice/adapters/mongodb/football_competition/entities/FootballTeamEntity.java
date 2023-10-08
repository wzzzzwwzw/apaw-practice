package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities;

import es.upm.miw.apaw_practice.domain.models.football_competition.FootballTeam;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Document
public class FootballTeamEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String city;
    private Integer foundationYear;
    private BigDecimal budget;
    private Boolean removed;

    public FootballTeamEntity() {
        //empty for framework
    }

    public FootballTeamEntity(
            String city,
            Integer foundationYear,
            BigDecimal budget,
            Boolean removed) {
        this.id = UUID.randomUUID().toString();
        this.city = city;
        this.foundationYear = foundationYear;
        this.budget = budget;
        this.removed = removed;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public FootballTeam toFootballTeam() {
        FootballTeam team = new FootballTeam();
        BeanUtils.copyProperties(this, team);
        return team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FootballTeamEntity that)) return false;
        return (Objects.equals(getId(), that.getId()))
                && (Objects.equals(getCity(), that.getCity()));
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "FootballTeamEntity{" +
                "Id='" + this.id +
                ", City='" + this.city +
                ", Foundation Year=" + this.foundationYear +
                ", Budget=" + this.budget +
                ", Removed=" + this.removed.toString() +
                '}';
    }
}
