package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class FootballGameEntity {
    @Id
    private String id;
    private LocalDateTime date;
    private String location;
    private String refereeName;
    private List<FootballPlayerEntity> players;

    public FootballGameEntity() {
        //empty for framework
    }

    public FootballGameEntity(
            LocalDateTime date,
            String location,
            String refereeName) {
        this.id = UUID.randomUUID().toString();
        this.date = date;
        this.location = location;
        this.refereeName = refereeName;
        this.players = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRefereeName() {
        return this.refereeName;
    }

    public void setRefereeName(String refereeName) {
        this.refereeName = refereeName;
    }

    public List<FootballPlayerEntity> getPlayers() {
        return this.players;
    }

    public void setPlayers(List<FootballPlayerEntity> players) {
        this.players = players;
    }

    public void addPlayer(FootballPlayerEntity player) {
        if (this.players == null) {
            this.players = new ArrayList<>();
        }

        this.players.add(player);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FootballGameEntity that)) return false;
        return (Objects.equals(getId(), that.getId()));
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "FootballGameEntity{" +
                "Id='" + this.id +
                ", Date='" + this.date.toString() +
                ", Location=" + this.location +
                ", Referee Name=" + this.refereeName +
                ", Players=" + this.players.toString() +
                '}';
    }
}
