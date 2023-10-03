package es.upm.miw.apaw_practice.domain.models.football_competition;

import java.time.LocalDateTime;

public class FootballGame {
    LocalDateTime date;
    String location;
    String refereeName;

    public FootballGame() {}

    public FootballGame(LocalDateTime date, String location, String refereeName) {
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

    @Override
    public String toString() {
        return "FootballGame{" +
                "Date=" + this.date.toString() +
                ", Location=" + this.location +
                ", Referee Name=" + this.refereeName +
                '}';
    }
}
