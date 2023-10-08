package es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.entities;

import es.upm.miw.apaw_practice.domain.models.coffee_shop.Transaction;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
@Document
public class TransactionEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String order;
    private BigDecimal totalPrice;
    private LocalDateTime payDate;

    public TransactionEntity() {
        //empty for framework
    }

    public TransactionEntity(String id, String order, BigDecimal totalPrice, LocalDateTime payDate) {
        this.id = UUID.randomUUID().toString();
        this.order = order;
        this.totalPrice = totalPrice;
        this.payDate = payDate;
    }

    public void fromTransaction(Transaction transaction) {
        BeanUtils.copyProperties(transaction, this);
    }

    public Transaction toTransaction() {
        Transaction transaction = new Transaction();
        BeanUtils.copyProperties(this, transaction);
        return transaction;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionEntity that = (TransactionEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(order, that.order) && Objects.equals(totalPrice, that.totalPrice) && Objects.equals(payDate, that.payDate);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
