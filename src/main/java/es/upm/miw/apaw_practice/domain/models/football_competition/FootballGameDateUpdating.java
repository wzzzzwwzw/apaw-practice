package es.upm.miw.apaw_practice.domain.models.football_competition;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FootballGameDateUpdating {
    private String id;
    private LocalDateTime date;

    public FootballGameDateUpdating() {
        //empty for framework
    }

    public FootballGameDateUpdating(String id, LocalDateTime date) {
        this.id = id;
        this.date = date;
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

    @Override
    public String toString() {
        return "FootballGameDateUpdating{" +
                "Id=" + this.id +
                ", Date=" + this.date.toString() +
                '}';
    }
}
