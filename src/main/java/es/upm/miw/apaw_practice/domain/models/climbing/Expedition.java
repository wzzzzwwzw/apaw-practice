package es.upm.miw.apaw_practice.domain.models.climbing;

import java.time.LocalDateTime;
import java.math.BigDecimal;

public class Expedition {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal totalExpense;

    public Expedition(LocalDateTime startDate, LocalDateTime endDate, BigDecimal totalExpense) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalExpense = totalExpense;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
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
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", totalExpense=" + totalExpense +
                '}';
    }
}
