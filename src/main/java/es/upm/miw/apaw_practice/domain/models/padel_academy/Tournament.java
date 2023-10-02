package es.upm.miw.apaw_practice.domain.models.padel_academy;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Tournament {
    private String name;
    private BigDecimal prize;
    private LocalDate schedule;
    private Academy academy;

    public Tournament(String name, BigDecimal prize, LocalDate schedule, Academy academy) {
        this.name = name;
        this.prize = prize;
        this.schedule = schedule;
        this.academy = academy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "name='" + name + '\'' +
                ", prize=" + prize +
                ", schedule=" + schedule +
                ", academy=" + academy +
                '}';
    }
}