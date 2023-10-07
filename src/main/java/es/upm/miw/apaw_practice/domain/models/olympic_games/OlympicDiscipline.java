package es.upm.miw.apaw_practice.domain.models.olympic_games;

import java.time.LocalDate;
import java.util.List;

public class OlympicDiscipline {

    private String name;
    private Integer numberOfCompetitions;
    private LocalDate additionDate;
    private List<OlympicCompetitor> competitors;

    public OlympicDiscipline() {
    }

    public OlympicDiscipline(String name, Integer numberOfCompetitions, LocalDate additionDate, List<OlympicCompetitor> competitors) {
        this.name = name;
        this.numberOfCompetitions = numberOfCompetitions;
        this.additionDate = additionDate;
        this.competitors = competitors;
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

    public List<OlympicCompetitor> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<OlympicCompetitor> competitors) {
        this.competitors = competitors;
    }

    @Override
    public String toString() {
        return "OlympicDiscipline{" +
                "name='" + name + '\'' +
                ", numberOfCompetitions=" + numberOfCompetitions +
                ", additionDate=" + additionDate +
                ", competitors=" + competitors +
                '}';
    }
}