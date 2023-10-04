package es.upm.miw.apaw_practice.adapters.mongodb;

import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.CarWorkshopSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.ComputerStoreSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.conference.ConferenceSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.FoodDeliverySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.RestaurantSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.shop.ShopSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.zoo.ZooSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.FoodDeliverySeederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseSeederService {

    private final ShopSeederService shopSeederService;
    private final ZooSeederService zooSeederService;
    private final ComputerStoreSeederService computerStoreSeederService;
    private final ConferenceSeederService conferenceSeederService;
    private final RestaurantSeederService restaurantSeederService;
    private final CarWorkshopSeederService carWorkshopSeederService;
    private final FoodDeliverySeederService foodDeliverySeederService;

    @Autowired
    public DatabaseSeederService(ShopSeederService shopSeederService, ZooSeederService zooSeederService,
            ComputerStoreSeederService computerStoreSeederService, ConferenceSeederService conferenceSeederService,
            RestaurantSeederService restaurantSeederService, CarWorkshopSeederService carWorkshopSeederService,
                                 FoodDeliverySeederService foodDeliverySeederService) {
        this.shopSeederService = shopSeederService;
        this.zooSeederService = zooSeederService;
        this.computerStoreSeederService = computerStoreSeederService;
        this.conferenceSeederService = conferenceSeederService;
        this.restaurantSeederService = restaurantSeederService;
        this.carWorkshopSeederService = carWorkshopSeederService;
        this.foodDeliverySeederService = foodDeliverySeederService;
        this.seedDatabase();
    }

    public void seedDatabase() {
        this.shopSeederService.seedDatabase();
        this.zooSeederService.seedDatabase();
        this.computerStoreSeederService.seedDatabase();
        this.conferenceSeederService.seedDatabase();
        this.restaurantSeederService.seedDatabase();
        this.carWorkshopSeederService.seedDatabase();
        this.foodDeliverySeederService.seedDatabase();
    }

    public void deleteAll() {
        this.shopSeederService.deleteAll();
        this.zooSeederService.deleteAll();
        this.computerStoreSeederService.deleteAll();
        this.conferenceSeederService.deleteAll();
        this.restaurantSeederService.deleteAll();
        this.carWorkshopSeederService.deleteAll();
        this.foodDeliverySeederService.deleteAll();
    }

    public void reSeedDatabase() {
        this.deleteAll();
        this.seedDatabase();
    }
}
