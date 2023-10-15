package es.upm.miw.apaw_practice.adapters.mongodb.climbing.entities;

import es.upm.miw.apaw_practice.domain.models.climbing.Expedition;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Document
public class ExpeditionEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String identifier;
    private LocalDate date;
    private BigDecimal totalExpense;

    public ExpeditionEntity() {

    }

    public ExpeditionEntity(Expedition expedition) {
        BeanUtils.copyProperties(expedition, this);
        this.id = UUID.randomUUID().toString();
        this.identifier = UUID.randomUUID().toString();
    }

    public ExpeditionEntity(LocalDate date, BigDecimal totalExpense) {
        this.id = UUID.randomUUID().toString();
        this.identifier = UUID.randomUUID().toString();
        this.date = date;
        this.totalExpense = totalExpense;
    }

    public String getId() {
        return id;
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

    public void fromExpedition(Expedition expedition) {
        BeanUtils.copyProperties(expedition, this);
    }

    public Expedition toExpedition() {
        Expedition expedition = new Expedition();
        BeanUtils.copyProperties(this, expedition);
        return expedition;
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (identifier.equals(((ExpeditionEntity) obj).identifier));
    }

    @Override
    public String toString() {
        return "ExpeditionEntity{" +
                "id='" + id + '\'' +
                ", identifier='" + identifier + '\'' +
                ", date=" + date +
                ", totalExpense=" + totalExpense +
                '}';
    }
}
