package es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.entities;

import es.upm.miw.apaw_practice.domain.models.padel_academy.Academy;
import es.upm.miw.apaw_practice.domain.models.padel_academy.Tournament;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Document
public class TournamentEntity {
    @Id
    private String id;
    private String title;
    private BigDecimal prize;
    private LocalDate schedule;
    @DBRef
    private AcademyEntity academyEntity;

    public TournamentEntity() {
        // Empty for framework
    }

    public TournamentEntity(Tournament tournament) {
        this.id = UUID.randomUUID().toString();
        BeanUtils.copyProperties(tournament, this);
    }

    public TournamentEntity(String title, BigDecimal prize, LocalDate schedule, AcademyEntity academyEntity) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.prize = prize;
        this.schedule = schedule;
        this.academyEntity = academyEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrize() {
        return prize;
    }

    public void setPrize(BigDecimal prize) {
        this.prize = prize;
    }

    public LocalDate getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDate schedule) {
        this.schedule = schedule;
    }

    public AcademyEntity getAcademyEntity() {
        return academyEntity;
    }

    public void setAcademyEntity(AcademyEntity academyEntity) {
        this.academyEntity = academyEntity;
    }

    public Tournament toTournament() {
        Tournament tournament = new Tournament();
        BeanUtils.copyProperties(this, tournament);
        return tournament;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TournamentEntity that = (TournamentEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TournamentEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", prize=" + prize +
                ", schedule=" + schedule +
                ", academyEntity=" + academyEntity +
                '}';
    }
}
