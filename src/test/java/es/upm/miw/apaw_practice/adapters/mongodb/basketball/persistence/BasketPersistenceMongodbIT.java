package es.upm.miw.apaw_practice.adapters.mongodb.basketball.persistence;
import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.PlayerEntity;
import es.upm.miw.apaw_practice.domain.models.basketball.Basket;
import es.upm.miw.apaw_practice.domain.models.basketball.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;
@TestConfig
class BasketPersistenceMongodbIT {
    @Autowired
    private BasketPersistenceMongodb basketPersistenceMongodb;
    @Test
    void testUpdate() {
        PlayerEntity playerEntity = new PlayerEntity("email1@gmail.com", "alero" , 19);
        Player player = playerEntity.toPlayer();
        Basket basket = this.basketPersistenceMongodb.update(new Basket(1, "canasta1", LocalDateTime.of(2023, Month.OCTOBER, 16, 16, 0), player));
        assertNotNull(basket);
        assertEquals(1, basket.getValue());
    }

}