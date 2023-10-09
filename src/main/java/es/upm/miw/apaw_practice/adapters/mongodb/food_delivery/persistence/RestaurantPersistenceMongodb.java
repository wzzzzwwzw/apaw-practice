package es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.daos.RestaurantRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.entities.RestaurantEntity;
import es.upm.miw.apaw_practice.domain.models.food_delivery.Restaurant;
import es.upm.miw.apaw_practice.domain.persistence_ports.food_delivery.RestaurantPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("restaurantPersistence")
public class RestaurantPersistenceMongodb implements RestaurantPersistence {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantPersistenceMongodb(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
       return restaurantRepository.save(new RestaurantEntity(restaurant)).toRestaurant();
    }

    @Override
    public boolean existName(String name) {
        return restaurantRepository.findByName(name).isPresent();
    }


}
