package es.upm.miw.apaw_practice.domain.models.zoo;

import java.math.BigDecimal;

public class ZooPriceUpdating {
    private String name;
    private BigDecimal ticketPrice;

    public ZooPriceUpdating(String name, BigDecimal ticketPrice) {
        this.name = name;
        this.ticketPrice = ticketPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "ZooPriceUpdating{" +
                "name='" + name + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
