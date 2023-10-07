package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.DishEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class DishRepositoryIT {
    @Autowired
    private DishRepository dishRepository;
    private static final String TITLE = "Pollo_con_patatas";

    @Test
    void testFindByTitle() {
        assertTrue(dishRepository.findByTitle(TITLE).isPresent());
        DishEntity dish = dishRepository.findByTitle(TITLE).get();
        assertEquals(new BigDecimal("13.5"), dish.getPrice());
        assertEquals("Carne", dish.getCategory().getTag());
    }
}
