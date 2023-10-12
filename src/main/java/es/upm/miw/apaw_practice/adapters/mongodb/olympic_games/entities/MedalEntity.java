package es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.entities;

import es.upm.miw.apaw_practice.domain.models.olympic_games.Competitor;
import es.upm.miw.apaw_practice.domain.models.olympic_games.Medal;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class MedalEntity {

    @Id
    private String id;
    private String tier;
    private Boolean teamMedal;
    private String competition;
    private CompetitorEntity winner;

    public MedalEntity() {
    }

    public MedalEntity(String tier, Boolean teamMedal, String competition, CompetitorEntity winner) {
        this.id = UUID.randomUUID().toString();
        this.tier = tier;
        this.teamMedal = teamMedal;
        this.competition = competition;
        this.winner = winner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public CompetitorEntity getWinner() {
        return winner;
    }

    public void setWinner(CompetitorEntity winner) {
        this.winner = winner;
    }

    public Medal toMedal() {
        Medal medal = new Medal();
        BeanUtils.copyProperties(this, medal, "winner");
        Competitor competitor = this.winner.toCompetitor();
        medal.setWinner(competitor);
        return medal;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((MedalEntity) obj).id));

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "MedalEntity{" +
                "id='" + id + '\'' +
                ", tier='" + tier + '\'' +
                ", teamMedal=" + teamMedal +
                ", competition='" + competition + '\'' +
                ", winner=" + winner +
                '}';
    }

}
