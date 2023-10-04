package es.upm.miw.apaw_practice.domain.models.coffee_Shop;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction {
    private BigDecimal totalPrice;
    private LocalDateTime PayDate;
    private Client client;

    public Transaction(BigDecimal totalPrice, LocalDateTime payDate, Client client) {
        this.totalPrice = totalPrice;
        PayDate = payDate;
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
        return PayDate;
    }

    public void setPayDate(LocalDateTime payDate) {
        PayDate = payDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "totalPrice=" + totalPrice +
                ", PayDate=" + PayDate +
                ", client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(totalPrice, that.totalPrice) && Objects.equals(PayDate, that.PayDate) && Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalPrice, PayDate, client);
    }
}
