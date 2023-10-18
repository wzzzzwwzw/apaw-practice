package es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class BasketRepositoryIT {

    @Autowired
    private BasketRepository basketRepository;

    @Test
    void testCreateAndRead() {
        LocalDateTime expectedDateTime = LocalDateTime.of(2023, Month.OCTOBER, 16, 16, 0);
        String playerEmail = "email1@gmail.com";
        int expectedScore = 3;

        assertTrue(this.basketRepository.findAll().stream()
                .anyMatch(basket ->
                        expectedScore == basket.getValue() &&
                                expectedDateTime.equals(basket.getBasketTime()) &&
                                playerEmail.equals(basket.getPlayer().getEmail())
                ));
    }


}
