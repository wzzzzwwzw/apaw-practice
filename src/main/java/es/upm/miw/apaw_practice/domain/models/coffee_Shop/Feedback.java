package es.upm.miw.apaw_practice.domain.models.coffee_Shop;

import java.time.LocalDateTime;
import java.util.Objects;

public class Feedback {
    private String description;
    private LocalDateTime date;
    private Client client;

    public Feedback(String description, LocalDateTime date, Client client) {
        this.description = description;
        this.date = date;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "description='" + description + '\'' +
                ", date=" + date +
                ", client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return Objects.equals(description, feedback.description) && Objects.equals(date, feedback.date) && Objects.equals(client, feedback.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, date, client);
    }
}
