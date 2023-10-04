package es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.entities.RestaurantEntity;
import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestConfig
class RestaurantRepositoryIT {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    void testFindByName(){
        assertTrue(this.restaurantRepository.findByName("La Pizzeria").isPresent());
        RestaurantEntity restaurant = this.restaurantRepository.findByName("La Pizzeria").get();
        assertEquals("Italian", restaurant.getType());
        assertEquals(50, restaurant.getMaximumOrders());
        assertEquals("Authentic Italian pizza", restaurant.getDescription());
        assertEquals("123 Calle de Gran Vía", restaurant.getAdress());

    }
}

