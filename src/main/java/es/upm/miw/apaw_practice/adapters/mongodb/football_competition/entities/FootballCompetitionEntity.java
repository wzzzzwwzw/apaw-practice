package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities;

import es.upm.miw.apaw_practice.domain.models.football_competition.FootballTeam;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class FootballCompetitionEntity {
    @Id
    private String id;
    private BigDecimal prize;
    @Indexed(unique = true)
    private String organizingEntity;
    private List<String> sponsors;
    private List<FootballTeam> teams;

    public FootballCompetitionEntity() {
        //empty for framework
    }

    public FootballCompetitionEntity(
            BigDecimal prize,
            String organizingEntity) {
        this.id = UUID.randomUUID().toString();
        this.prize = prize;
        this.organizingEntity = organizingEntity;
        this.sponsors = new ArrayList<>();
        this.teams = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPrize() {
        return this.prize;
    }

    public void setPrize(BigDecimal prize) {
        this.prize = prize;
    }

    public String getOrganizingEntity() {
        return this.organizingEntity;
    }

    public void setOrganizingEntity(String organizingEntity) {
        this.organizingEntity = organizingEntity;
    }

    public List<String> getSponsors() {
        return this.sponsors;
    }

    public void setSponsors(List<String> sponsors) {
        this.sponsors = sponsors;
    }

    public void addSponsor(String sponsor) {
        if (this.sponsors == null) {
            this.sponsors = new ArrayList<>();
        }

        this.sponsors.add(sponsor);
    }

    public List<FootballTeam> getTeams() {
        return this.teams;
    }

    public void setTeams(List<FootballTeam> teams) {
        this.teams = teams;
    }

    public void addTeam(FootballTeam team) {
        if (this.teams == null) {
            this.teams = new ArrayList<>();
        }

        this.teams.add(team);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FootballCompetitionEntity that)) return false;
        return (Objects.equals(getId(), that.getId()))
                && (Objects.equals(getOrganizingEntity(), that.getOrganizingEntity()));
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "FootballCompetitionEntity{" +
                "Id='" + this.id +
                ", Prize='" + this.prize +
                ", OrganizingEntity=" + this.organizingEntity +
                ", Sponsors=" + this.sponsors.toString() +
                ", Teams=" + this.teams.toString() +
                '}';
    }
}
