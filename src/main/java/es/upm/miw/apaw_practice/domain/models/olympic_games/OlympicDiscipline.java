package es.upm.miw.apaw_practice.domain.models.olympic_games;

import java.time.LocalDate;

public class OlympicDiscipline {

    private String name;
    private Integer numberOfCompetitions;
    private LocalDate additionDate;

    public OlympicDiscipline() {
    }

    public OlympicDiscipline(String name, Integer numberOfCompetitions, LocalDate additionDate) {
        this.name = name;
        this.numberOfCompetitions = numberOfCompetitions;
        this.additionDate = additionDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfCompetitions() {
        return numberOfCompetitions;
    }

    public void setNumberOfCompetitions(Integer numberOfCompetitions) {
        this.numberOfCompetitions = numberOfCompetitions;
    }

    public LocalDate getAdditionDate() {
        return additionDate;
    }

    public void setAdditionDate(LocalDate additionDate) {
        this.additionDate = additionDate;
    }


    @Override
    public String toString() {
        return "OlympicDiscipline{" +
                "name='" + name + '\'' +
                ", numberOfCompetitions=" + numberOfCompetitions +
                ", additionDate=" + additionDate +
                '}';
    }
}