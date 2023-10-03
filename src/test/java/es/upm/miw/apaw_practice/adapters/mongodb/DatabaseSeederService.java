package es.upm.miw.apaw_practice.adapters.mongodb;

import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.ComputerStoreSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.RestaurantSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.shop.ShopSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.zoo.ZooSeederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseSeederService {

    private final ShopSeederService shopSeederService;
    private final ZooSeederService zooSeederService;
    private final ComputerStoreSeederService computerStoreSeederService;
    private final RestaurantSeederService restaurantSeederService;

    @Autowired
    public DatabaseSeederService(ShopSeederService shopSeederService, ZooSeederService zooSeederService, ComputerStoreSeederService computerStoreSeederService,
                                 RestaurantSeederService restaurantSeederService) {
        this.shopSeederService = shopSeederService;
        this.zooSeederService = zooSeederService;
        this.computerStoreSeederService = computerStoreSeederService;
        this.restaurantSeederService = restaurantSeederService;
        this.seedDatabase();
    }

    public void seedDatabase() {
        this.shopSeederService.seedDatabase();
        this.zooSeederService.seedDatabase();
        this.computerStoreSeederService.seedDatabase();
        this.restaurantSeederService.seedDatabase();
    }

    public void deleteAll() {
        this.shopSeederService.deleteAll();
        this.zooSeederService.deleteAll();
        this.computerStoreSeederService.deleteAll();
        this.restaurantSeederService.deleteAll();
    }

    public void reSeedDatabase() {
        this.deleteAll();
        this.seedDatabase();
    }
}
