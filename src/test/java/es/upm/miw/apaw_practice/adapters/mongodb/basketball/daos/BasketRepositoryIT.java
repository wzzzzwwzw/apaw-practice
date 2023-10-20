package es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.BasketEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class BasketRepositoryIT {

    @Autowired
    private BasketRepository basketRepository;

    @Test
    void testCreateAndRead() {
        Optional<BasketEntity> basket = basketRepository.findByIdentifier("canasta2");
        assertTrue(basket.isPresent());
        assertEquals(2, basket.get().getValue());
        assertEquals("canasta2", basket.get().getIdentifier());
        assertEquals(LocalDateTime.of(2023, Month.OCTOBER, 16, 15, 0), basket.get().getBasketTime());
    }


}
