package es.upm.miw.apaw_practice.domain.models.football_competition;

import java.math.BigDecimal;
import java.util.ArrayList;

public class FootballCompetition {
    BigDecimal prize;
    String organizingEntity;
    ArrayList<String> sponsors;

    public FootballCompetition() {
        this.sponsors = new ArrayList<>();
    }

    public FootballCompetition(BigDecimal prize, String organizingEntity) {
        this();
        this.prize = prize;
        this.organizingEntity = organizingEntity;
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

    public ArrayList<String> getSponsors() {
        return this.sponsors;
    }

    public void setSponsors(ArrayList<String> sponsors) {
        this.sponsors = sponsors;
    }

    public void addSponsor(String sponsor) {
        if (this.sponsors == null) {
            this.sponsors = new ArrayList<>();
        }

        this.sponsors.add(sponsor);
    }

    @Override
    public String toString() {
        return "FootballCompetition{" +
                "Prize=" + this.prize +
                ", OrganizingEntity=" + this.organizingEntity +
                ", Sponsors=" + this.sponsors.toString() +
                '}';
    }
}
