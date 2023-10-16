package es.upm.miw.apaw_practice.domain.models.olympic_games;

import java.time.LocalDate;
import java.util.List;

public class Discipline {

    private String name;
    private Integer numberOfCompetitions;
    private LocalDate additionDate;
    private List<Competitor> competitors;

    public Discipline() {
    }

    public Discipline(String name, Integer numberOfCompetitions, LocalDate additionDate, List<Competitor> competitors) {
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

    public List<Competitor> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<Competitor> competitors) {
        this.competitors = competitors;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "name='" + name + '\'' +
                ", numberOfCompetitions=" + numberOfCompetitions +
                ", additionDate=" + additionDate +
                ", competitors=" + competitors +
                '}';
    }
}