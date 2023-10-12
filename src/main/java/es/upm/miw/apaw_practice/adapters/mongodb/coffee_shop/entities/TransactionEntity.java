package es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.entities;

import es.upm.miw.apaw_practice.domain.models.coffee_shop.Transaction;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Document
public class TransactionEntity {
    private String order;
    private BigDecimal totalPrice;
    private LocalDateTime payDate;

    public TransactionEntity() {
        //empty for framework
    }

    public TransactionEntity(String order, BigDecimal totalPrice, LocalDateTime payDate) {
        this.order = order;
        this.totalPrice = totalPrice;
        this.payDate = payDate;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDateTime payDate) {
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
    public String toString() {
        return "TransactionEntity{" +
                "order='" + order + '\'' +
                ", totalPrice=" + totalPrice +
                ", payDate=" + payDate +
                '}';
    }
}
