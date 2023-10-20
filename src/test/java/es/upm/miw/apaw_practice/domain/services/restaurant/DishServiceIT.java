package es.upm.miw.apaw_practice.domain.services.restaurant;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.RestaurantSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.restaurant.Dish;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class DishServiceIT {

    @Autowired
    DishService dishService;

    @Autowired
    RestaurantSeederService restaurantSeederService;

    @AfterEach
    void resetDataBase() {
        this.restaurantSeederService.deleteAll();
        this.restaurantSeederService.seedDatabase();
    }

    @Test
    void testUpdatePrice() {
        Dish dish = this.dishService.updatePrice("Ternera_banhada_en_setas", new BigDecimal("20.5"));
        assertEquals(BigDecimal.valueOf(20.5), dish.getPrice());
    }

    @Test
    void testUpdatePriceNotFound() {
        RuntimeException exception = assertThrows(NotFoundException.class, () -> {
            this.dishService.updatePrice("abcdefg", new BigDecimal("10"));
        });
        assertTrue(exception.getMessage().contains("Dish title:abcdefg"));
    }

    @Test
    void testFindSumOfPriceByAvailableAndLastModificationThisMonth() {
        BigDecimal totalPrice = this.dishService.findSumOfPriceByAvailableAndLastModificationThisMonth(true);
        assertEquals(BigDecimal.valueOf(13.5), totalPrice);
    }

}
