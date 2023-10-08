package es.upm.miw.apaw_practice.domain.models.olympic_games;


public class OlympicMedal {

    private String tier;
    private Boolean teamMedal;
    private String competition;
    private OlympicCompetitor winner;


    public OlympicMedal() {
    }

    public OlympicMedal(String tier, Boolean teamMedal, String competition, OlympicCompetitor winner) {
        this.tier = tier;
        this.teamMedal = teamMedal;
        this.competition = competition;
        this.winner = winner;
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

    public OlympicCompetitor getWinner() {
        return winner;
    }

    public void setWinner(OlympicCompetitor winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "OlympicMedal{" +
                "tier='" + tier + '\'' +
                ", teamMedal=" + teamMedal +
                ", competition='" + competition + '\'' +
                ", winner=" + winner +
                '}';
    }
}
