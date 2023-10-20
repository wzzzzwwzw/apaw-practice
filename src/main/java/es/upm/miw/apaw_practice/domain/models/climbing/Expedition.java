package es.upm.miw.apaw_practice.domain.models.climbing;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Expedition {
    private String identifier;
    private LocalDate date;
    private BigDecimal totalExpense;

    public Expedition() {
        //empty for framework
    }

    public Expedition(LocalDate date, BigDecimal totalExpense) {
        this.date = date;
        this.totalExpense = totalExpense;
    }

    public Expedition(String identifier, LocalDate date, BigDecimal totalExpense) {
        this.identifier = identifier;
        this.date = date;
        this.totalExpense = totalExpense;
    }

    public void doDefault() {
        if (this.totalExpense == null) {
            this.totalExpense = BigDecimal.ZERO;
        }
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(BigDecimal totalExpense) {
        this.totalExpense = totalExpense;
    }

    @Override
    public String toString() {
        return "Expedition{" +
                "identifier='" + identifier + '\'' +
                ", date=" + date +
                ", totalExpense=" + totalExpense +
                '}';
    }

}
