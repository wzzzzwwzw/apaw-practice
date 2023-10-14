package es.upm.miw.apaw_practice.domain.services.food_delivery;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.food_delivery.Restaurant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
class RestaurantServiceIT {

    @Autowired
    private RestaurantService restaurantService;

    @Test
    void testCreate(){
        Restaurant restaurant = new Restaurant("Sushi Haven", "Japanese", "Serving fresh and delicious sushi",
                "789 Pine Avenue, Sushiville", 30);
        Restaurant newRestaurant = this.restaurantService.create(restaurant);
        assertNotNull(newRestaurant);
        assertEquals("Sushi Haven",newRestaurant.getName());
        assertEquals("Japanese",newRestaurant.getType());
        assertEquals("789 Pine Avenue, Sushiville",newRestaurant.getAdress());

    }

}


