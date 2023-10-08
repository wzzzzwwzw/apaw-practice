package es.upm.miw.apaw_practice.domain.models.padel_academy;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Tournament {
    private String title;
    private BigDecimal prize;
    private LocalDate schedule;
    private Academy academy;

    public Tournament() {
        //empty for framework
    }

    public Tournament(String title, BigDecimal prize, LocalDate schedule, Academy academy) {
        this.title = title;
        this.prize = prize;
        this.schedule = schedule;
        this.academy = academy;
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

    public Academy getAcademy() {
        return academy;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "title='" + title + '\'' +
                ", prize=" + prize +
                ", schedule=" + schedule +
                ", academy=" + academy +
                '}';
    }
}