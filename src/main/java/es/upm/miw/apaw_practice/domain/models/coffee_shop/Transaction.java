package es.upm.miw.apaw_practice.domain.models.coffee_shop;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private BigDecimal totalPrice;
    private LocalDateTime payDate;
    private Client client;

    public Transaction(BigDecimal totalPrice, LocalDateTime payDate, Client client) {
        this.totalPrice = totalPrice;
        this.payDate = payDate;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
        payDate = payDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "totalPrice=" + totalPrice +
                ", PayDate=" + payDate +
                ", client=" + client +
                '}';
    }

}
