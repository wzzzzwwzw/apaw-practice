package es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities;
import es.upm.miw.apaw_practice.domain.models.basketball.Basket;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document
public class BasketEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String identifier;
    private Integer value;
    private LocalDateTime basketTime;
    @DBRef
    private PlayerEntity player;

    public BasketEntity() {

    }


    public BasketEntity(Integer value, LocalDateTime basketTime, PlayerEntity player) {
        this.identifier = UUID.randomUUID().toString();
        this.value = value;
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
    public PlayerEntity getPlayer() {
        return player;
    }
    public void setPlayer(PlayerEntity player) {
        this.player = player;
    }

    public Basket toBasket(){
        return new Basket(this.value, this.identifier, this.basketTime, this.player.toPlayer());
    }
    @Override
    public String toString() {
        return "BasketEntity{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", identifier='" + identifier + '\'' +
                ", basketTime=" + basketTime +
                ", player=" + player +
                '}';
    }
}
