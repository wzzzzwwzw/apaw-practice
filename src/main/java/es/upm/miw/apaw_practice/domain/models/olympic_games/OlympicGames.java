package es.upm.miw.apaw_practice.domain.models.olympic_games;

import java.time.LocalDate;
import java.util.List;

public class OlympicGames {

    private Integer edition;
    private String hostingPlace;
    private LocalDate startDate;
    private Boolean summerGames;
    private List<OlympicDiscipline> disciplines;
    private List<OlympicCompetitor> competitors;

    public OlympicGames() {}


    public OlympicGames(Integer edition, String hostingPlace, LocalDate startDate, Boolean summerGames, List<OlympicDiscipline> disciplines, List<OlympicCompetitor> competitors) {
        this.edition = edition;
        this.hostingPlace = hostingPlace;
        this.startDate = startDate;
        this.summerGames = summerGames;
        this.disciplines = disciplines;
        this.competitors = competitors;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public String getHostingPlace() {
        return hostingPlace;
    }

    public void setHostingPlace(String hostingPlace) {
        this.hostingPlace = hostingPlace;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Boolean isSummerGames() {
        return summerGames;
    }

    public void setSummerGames(Boolean summerGames) {
        this.summerGames = summerGames;
    }

    public List<OlympicDiscipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<OlympicDiscipline> disciplines) {
        this.disciplines = disciplines;
    }

    public List<OlympicCompetitor> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<OlympicCompetitor> competitors) {
        this.competitors = competitors;
    }

    @Override
    public String toString() {
        return "OlympicGames{" +
                "edition=" + edition +
                ", hostingPlace='" + hostingPlace + '\'' +
                ", startDate=" + startDate +
                ", summerGames=" + summerGames +
                ", disciplines=" + disciplines +
                ", competitors=" + competitors +
                '}';
    }
}