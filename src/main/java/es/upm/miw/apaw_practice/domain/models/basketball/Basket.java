package es.upm.miw.apaw_practice.domain.models.basketball;

import java.time.LocalDateTime;

class Basket {
    private Integer value;
    private String description;
    private LocalDateTime basketTime;

    public Basket() {

    }

    public Basket(Integer value, String description, LocalDateTime basketTime) {
        this.value = value;
        this.description = description;
        this.basketTime = basketTime;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getBasketTime() {
        return basketTime;
    }

    public void setBasketTime(LocalDateTime basketTime) {
        this.basketTime = basketTime;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "value='" + value + '\'' +
                ", description='" + description + '\'' +
                ", basketTime=" + basketTime +
                '}';
    }
}
