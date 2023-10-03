package es.upm.miw.apaw_practice.domain.models.football_competition;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FootballGame {
    private LocalDateTime date;
    private String location;
    private String refereeName;
    private List<FootballPlayer> players;

    public FootballGame() {
        this.players = new ArrayList<>();
    }

    public FootballGame(LocalDateTime date, String location, String refereeName) {
        this();
        this.date = date;
        this.location = location;
        this.refereeName = refereeName;
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

    public List<FootballPlayer> getPlayers() {
        return this.players;
    }

    public void setPlayers(List<FootballPlayer> players) {
        this.players = players;
    }

    public void addPlayer(FootballPlayer player) {
        if (this.players == null) {
            this.players = new ArrayList<>();
        }

        this.players.add(player);
    }

    @Override
    public String toString() {
        return "FootballGame{" +
                "Date=" + this.date.toString() +
                ", Location=" + this.location +
                ", Referee Name=" + this.refereeName +
                '}';
    }
}
