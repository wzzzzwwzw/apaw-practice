package es.upm.miw.apaw_practice.domain.models.coffee_shop;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private String order;
    private BigDecimal totalPrice;
    private LocalDateTime payDate;

    public Transaction() {
    }

    public Transaction(String order, BigDecimal totalPrice, LocalDateTime payDate) {
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

    @Override
    public String toString() {
        return "Transaction{" +
                "order='" + order + '\'' +
                ", totalPrice=" + totalPrice +
                ", payDate=" + payDate +
                '}';
    }
}
