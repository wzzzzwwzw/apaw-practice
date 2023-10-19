package es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities;

import es.upm.miw.apaw_practice.domain.models.basketball.Basket;
import org.springframework.beans.BeanUtils;
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
    private PlayerEntity playerEntity;

    public BasketEntity() {

    }

    public BasketEntity(Integer value, String identifier, LocalDateTime basketTime, PlayerEntity playerEntity) {
        this.id = UUID.randomUUID().toString();
        this.identifier = identifier;
        this.value = value;
        this.basketTime = basketTime;
        this.playerEntity = playerEntity;
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
        return playerEntity;
    }

    public void setPlayer(PlayerEntity player) {
        this.playerEntity = player;
    }

    public void fromBasket(Basket basket) {
        BeanUtils.copyProperties(basket, this);
    }

    public Basket toBasket() {
        return new Basket(this.value, this.identifier, this.basketTime, this.playerEntity.toPlayer());
    }

    @Override
    public String toString() {
        return "BasketEntity{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", identifier='" + identifier + '\'' +
                ", basketTime=" + basketTime +
                ", player=" + playerEntity +
                '}';
    }
}
