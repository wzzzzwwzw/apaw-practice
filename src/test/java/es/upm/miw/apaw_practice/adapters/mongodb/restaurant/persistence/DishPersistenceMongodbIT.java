package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.RestaurantSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.restaurant.CategoryRestaurant;
import es.upm.miw.apaw_practice.domain.models.restaurant.Dish;
import es.upm.miw.apaw_practice.domain.models.restaurant.Ingredient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class DishPersistenceMongodbIT {

    @Autowired
    private DishPersistenceMongodb dishPersistence;

    @Autowired
    private RestaurantSeederService restaurantSeederService;

    @Test
    void testUpdate() {
        Optional<Dish> dish = this.dishPersistence.readAll()
                .filter(dishItem -> "Pollo_con_patatas".equals(dishItem.getTitle()))
                .findFirst();
        assertTrue(dish.isPresent());
        BigDecimal price = dish.get().getPrice();

        dishPersistence.update(new Dish(dish.get().getTitle(), new BigDecimal("15.5"), dish.get().getCategory(), dish.get().getIngredients()));
        Optional<Dish> updatedDish = this.dishPersistence.readAll()
                .filter(dishItem -> "Pollo_con_patatas".equals(dishItem.getTitle()))
                .findFirst();
        assertTrue(updatedDish.isPresent());
        BigDecimal updatedPrice = updatedDish.get().getPrice();
        assertNotEquals(price, updatedPrice);
        restaurantSeederService.deleteAll();
        restaurantSeederService.seedDatabase();
    }

    @Test
    void testUpdateNotFound() {
        Dish dish = new Dish("Macarrones", new BigDecimal("8.5"), new CategoryRestaurant("Pasta", "Amarillo"),
                List.of(new Ingredient("Macarron", false, true)));
        RuntimeException exception = assertThrows(NotFoundException.class, () -> {
            this.dishPersistence.update(dish);
        });
        assertTrue(exception.getMessage().contains("Dish title:Macarrones"));
    }

    @Test
    void testIncreasePrices() {
        Float incrementPrice = 2f;

        Optional<Dish> dish = this.dishPersistence.readAll()
                .filter(dishItem -> "Pollo_con_patatas".equals(dishItem.getTitle()))
                .findFirst();
        assertTrue(dish.isPresent());
        BigDecimal price = dish.get().getPrice();
        assertEquals(new BigDecimal("13.5"), price);

        dishPersistence.increasePrices(incrementPrice);
        Optional<Dish> updatedDish = this.dishPersistence.readAll()
                .filter(dishItem -> "Pollo_con_patatas".equals(dishItem.getTitle()))
                .findFirst();
        assertTrue(updatedDish.isPresent());
        BigDecimal updatedPrice = updatedDish.get().getPrice();
        assertEquals(new BigDecimal("15.5"), updatedPrice);

        restaurantSeederService.deleteAll();
        restaurantSeederService.seedDatabase();
    }

}
