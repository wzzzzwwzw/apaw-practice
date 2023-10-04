package es.upm.miw.apaw_practice.domain.models.olympic_games;


public class OlympicMedal {

    private String tier;
    private Boolean teamMedal;
    private String competition;

    public OlympicMedal() {
    }


    public OlympicMedal(String tier, Boolean teamMedal, String competition) {
        this.tier = tier;
        this.teamMedal = teamMedal;
        this.competition = competition;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public Boolean isTeamMedal() {
        return teamMedal;
    }

    public void setTeamMedal(Boolean teamMedal) {
        this.teamMedal = teamMedal;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }


    @Override
    public String toString() {
        return "OlympicMedal{" +
                "tier='" + tier + '\'' +
                ", teamMedal=" + teamMedal +
                ", competition='" + competition + '\'' +
                '}';
    }
}
