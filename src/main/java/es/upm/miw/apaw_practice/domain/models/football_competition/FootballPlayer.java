package es.upm.miw.apaw_practice.domain.models.football_competition;

import java.math.BigDecimal;

public class FootballPlayer {
    private String name;
    private BigDecimal salary;
    private Float height;
    private Integer goals;
    private Integer assists;
    private FootballTeam team;

    public FootballPlayer() {
        // empty for framework
    }

    public static FootballPlayerBuilders.Name builder() {
        return new Builder();
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
    public String toString() {
        return "FootballPlayer{" +
                "Name=" + this.name +
                ", Salary=" + this.salary +
                ", Height=" + this.height +
                ", Goals=" + this.goals +
                ", Assists=" + this.assists +
                '}';
    }

    public static class Builder implements FootballPlayerBuilders.Name, FootballPlayerBuilders.Optionals {
        private final FootballPlayer footballPlayer;

        public Builder() {
            this.footballPlayer = new FootballPlayer();
        }

        @Override
        public FootballPlayerBuilders.Optionals name(String name) {
            this.footballPlayer.setName(name);
            return this;
        }

        @Override
        public FootballPlayerBuilders.Optionals salary(BigDecimal salary) {
            this.footballPlayer.setSalary(salary);
            return this;
        }

        @Override
        public FootballPlayerBuilders.Optionals height(float height) {
            this.footballPlayer.setHeight(height);
            return this;
        }

        @Override
        public FootballPlayerBuilders.Optionals goals(Integer goals) {
            this.footballPlayer.setGoals(goals);
            return this;
        }

        @Override
        public FootballPlayerBuilders.Optionals assists(Integer assists) {
            this.footballPlayer.setAssists(assists);
            return this;
        }

        @Override
        public FootballPlayerBuilders.Optionals team(FootballTeam team) {
            this.footballPlayer.setTeam(team);
            return this;
        }

        @Override
        public FootballPlayer build() {
            return this.footballPlayer;
        }
    }
}
