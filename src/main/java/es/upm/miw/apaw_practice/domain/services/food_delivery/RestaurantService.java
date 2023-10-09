package es.upm.miw.apaw_practice.domain.services.food_delivery;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.food_delivery.Restaurant;
import es.upm.miw.apaw_practice.domain.persistence_ports.food_delivery.RestaurantPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    private final RestaurantPersistence restaurantPersistence;

    @Autowired
    public RestaurantService(RestaurantPersistence restaurantPersistence){
        this.restaurantPersistence = restaurantPersistence;
    }

    public Restaurant create(Restaurant restaurant) {
        this.assertNameNotExist(restaurant.getName());
        return restaurantPersistence.create(restaurant);

    }

    public void assertNameNotExist(String name){
        if(this.restaurantPersistence.existName(name)){
            throw new ConflictException("Name exist: " + name);
        }
    }

}
