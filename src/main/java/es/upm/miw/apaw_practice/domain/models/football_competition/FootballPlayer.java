package es.upm.miw.apaw_practice.domain.models.football_competition;

import java.math.BigDecimal;

public class FootballPlayer {
    String name;
    BigDecimal salary;
    Float height;
    Integer goals;
    Integer assists;

    public FootballPlayer() {}

    public FootballPlayer(String name, BigDecimal salary, Float height, Integer goals, Integer assists) {
        this.name = name;
        this.salary = salary;
        this.height = height;
        this.goals = goals;
        this.assists = assists;
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

    @Override
    public String toString() {
        return "FootballPlayer{" +
                "Name=" + this.name +
                ", Salary=" + this.salary +
                ", Height=" + this.height +
                ", Goals=" + this.goals +
                ", Assists=" + this.assists +
                '}';
    }
}
