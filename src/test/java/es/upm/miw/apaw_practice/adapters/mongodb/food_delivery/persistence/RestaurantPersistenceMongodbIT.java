package es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.food_delivery.Restaurant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class RestaurantPersistenceMongodbIT {


    @Autowired
    private RestaurantPersistenceMongodb restaurantPersistence;

    @Test
    void testNameNotExist() {
        assertTrue(this.restaurantPersistence.existName("Taco Fiesta"));
    }

    @Test
    void testCreate() {
        Restaurant restaurant = new Restaurant("La pizzeria de Carlos", "Italian", "italian food", "89 Calle de atocha", 30);
        Restaurant newRestaurant = this.restaurantPersistence.create(restaurant);
        assertTrue(this.restaurantPersistence.existName("La pizzeria de Carlos"));
        assertEquals("Italian", newRestaurant.getType());
        assertEquals(30, newRestaurant.getMaximumOrders());


    }

    @Test
    void testCreateWithBuilder() {
        Restaurant restaurant = Restaurant.builder().name("Restaurant A")
                .type("Italian")
                .description("Authentic Italian cuisine")
                .adress("123 Pasta Avenue")
                .maximumOrders(50)
                .build();
        Restaurant newRestaurant = this.restaurantPersistence.create(restaurant);
        assertEquals("Restaurant A", newRestaurant.getName());
        assertEquals("Italian", newRestaurant.getType());
        assertEquals("Authentic Italian cuisine", newRestaurant.getDescription());
        assertEquals("123 Pasta Avenue", newRestaurant.getAdress());
        assertEquals(50, newRestaurant.getMaximumOrders());


    }
}


