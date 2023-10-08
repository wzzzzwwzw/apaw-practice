package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities;

import es.upm.miw.apaw_practice.domain.models.football_competition.FootballTeam;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class FootballPlayerEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private BigDecimal salary;
    private Float height;
    private Integer goals;
    private Integer assists;
    private FootballTeam team;

    public FootballPlayerEntity() {
        //empty for framework
    }

    public FootballPlayerEntity(
            String name,
            BigDecimal salary,
            Float height,
            Integer goals,
            Integer assists,
            FootballTeam team) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.salary = salary;
        this.height = height;
        this.goals = goals;
        this.assists = assists;
        this.team = team;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Float getHeight() {
        return this.height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Integer getGoals() {
        return this.goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getAssists() {
        return this.assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public FootballTeam getTeam() {
        return this.team;
    }

    public void setTeam(FootballTeam team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FootballPlayerEntity that)) return false;
        return (Objects.equals(getId(), that.getId()) || Objects.equals(getName(), that.getName()))
                && Objects.equals(getTeam(), that.getTeam());
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "FootballPlayerEntity{" +
                "Id='" + this.id +
                ", Name='" + this.name +
                ", Salary=" + this.salary +
                ", Height=" + this.height +
                ", Goals=" + this.goals +
                ", Assists=" + this.assists +
                ", Team=" + this.team.toString() +
                '}';
    }
}
