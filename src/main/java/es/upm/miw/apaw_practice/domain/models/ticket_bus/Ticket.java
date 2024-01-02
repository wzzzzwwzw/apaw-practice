package es.upm.miw.apaw_practice.domain.models.ticket_bus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Ticket {
    private String reference;
    private String departure;
    private String arrive;
    private LocalDateTime registrationDate;
    private BigDecimal price;

    public Ticket() {
    }

    public Ticket(String reference, String departure, String arrive, LocalDateTime registrationDate, BigDecimal price) {
        this.reference = reference;
        this.departure = departure;
        this.arrive = arrive;
        this.registrationDate = registrationDate;
        this.price = price;
    }

    public Ticket(String departure, String arrive, BigDecimal price) {
        this.departure=departure;
        this.arrive=arrive;
        this.price=price;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrive() {
        return arrive;
    }

    public void setArrive(String arrive) {
        this.arrive = arrive;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket ticket)) return false;
        return Objects.equals(reference, ticket.reference)
                && Objects.equals(departure, ticket.departure)
                && Objects.equals(arrive, ticket.arrive)
                && Objects.equals(registrationDate, ticket.registrationDate);

    }

    @Override
    public int hashCode() {
        return Objects.hash(reference, departure, arrive, registrationDate);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "reference='" + reference + '\'' +
                ", departure='" + departure + '\'' +
                ", arrive='" + arrive + '\'' +
                ", registrationDate=" + registrationDate +
                ", price=" + price +
                '}';
    }
}
