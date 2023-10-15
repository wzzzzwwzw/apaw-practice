package es.upm.miw.apaw_practice.domain.models.basketball;

import java.time.LocalDateTime;

class Basket {
    private String identifier;
    private Integer value;
    private LocalDateTime basketTime;
    private Player player;

    public Basket() {

    }


    public Basket(Integer value, String identifier, LocalDateTime basketTime, Player player) {
        this.value = value;
        this.identifier = identifier;
        this.basketTime = basketTime;
        this.player=player;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public LocalDateTime getBasketTime() {
        return basketTime;
    }

    public void setBasketTime(LocalDateTime basketTime) {
        this.basketTime = basketTime;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "value='" + value + '\'' +
                ", identifier='" + identifier + '\'' +
                ", basketTime=" + basketTime +
                '}';
    }
}
