package es.upm.miw.apaw_practice.domain.models.olympic_games;

import es.upm.miw.apaw_practice.domain.models.olympic_games.builders.CompetitorBuilders;

public class Competitor {
    private String name;
    private String nationality;
    private Integer age;

    public Competitor() {
    }


    public Competitor(String name, String nationality, Integer age) {
        this.name = name;
        this.nationality = nationality;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", age=" + age +
                '}';
    }

    public static class Builder implements CompetitorBuilders.Name, CompetitorBuilders.Optionals {
        private final Competitor competitor;

        public Builder() {
            competitor = new Competitor();
        }

        @Override
        public CompetitorBuilders.Optionals name(String name) {
            this.competitor.name = name;
            return this;
        }

        @Override
        public CompetitorBuilders.Optionals nationality(String nationality) {
            this.competitor.nationality = nationality;
            return this;
        }

        @Override
        public CompetitorBuilders.Optionals age(Integer age) {
            this.competitor.age = age;
            return this;
        }

        @Override
        public Competitor build() {
            return this.competitor;
        }
    }
}
