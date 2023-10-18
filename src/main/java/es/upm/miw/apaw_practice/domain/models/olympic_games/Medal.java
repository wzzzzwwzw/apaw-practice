package es.upm.miw.apaw_practice.domain.models.olympic_games;


public class Medal {

    private String medalID;
    private String tier;
    private Boolean teamMedal;
    private String competition;
    private Competitor winner;


    public Medal() {
    }

    public Medal(String medalID, String tier, Boolean teamMedal, String competition, Competitor winner) {
        this.tier = tier;
        this.teamMedal = teamMedal;
        this.competition = competition;
        this.winner = winner;
        this.medalID = medalID;
    }

    public String getMedalID() {
        return medalID;
    }

    public void setMedalID(String medalID) {
        this.medalID = medalID;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public Boolean getTeamMedal() {
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

    public Competitor getWinner() {
        return winner;
    }

    public void setWinner(Competitor winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "Medal{" +
                "medalID='" + medalID + '\'' +
                ", tier='" + tier + '\'' +
                ", teamMedal=" + teamMedal +
                ", competition='" + competition + '\'' +
                ", winner=" + winner +
                '}';
    }
}
