package es.upm.miw.apaw_practice.adapters.mongodb;

import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.CarDealershipSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.CarWorkshopSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.ComputerStoreSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.conference.ConferenceSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.FormulaOneSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.MuseumSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.music.MusicSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.RestaurantSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.shop.ShopSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.zoo.ZooSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.FoodDeliverySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.VideogameCompanySeederService;
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
    private final CarDealershipSeederService carDealershipSeederService;
    private final FormulaOneSeederService formulaOneSeederService;
    private final VideogameCompanySeederService videogameCompanySeederService;
    private final MuseumSeederService museumSeederService;

    private final MusicSeederService musicSeederService;

    @Autowired
    public DatabaseSeederService(ShopSeederService shopSeederService, ZooSeederService zooSeederService,
            ComputerStoreSeederService computerStoreSeederService, ConferenceSeederService conferenceSeederService,
            RestaurantSeederService restaurantSeederService, CarWorkshopSeederService carWorkshopSeederService,
                                 FoodDeliverySeederService foodDeliverySeederService,
            CarDealershipSeederService carDealershipSeederService, FormulaOneSeederService formulaOneSeederService,
                                 VideogameCompanySeederService videogameCompanySeederService,
                                 MuseumSeederService museumSeederService, MusicSeederService musicSeederService) {
        this.shopSeederService = shopSeederService;
        this.zooSeederService = zooSeederService;
        this.computerStoreSeederService = computerStoreSeederService;
        this.conferenceSeederService = conferenceSeederService;
        this.restaurantSeederService = restaurantSeederService;
        this.carWorkshopSeederService = carWorkshopSeederService;
        this.foodDeliverySeederService = foodDeliverySeederService;
        this.carDealershipSeederService = carDealershipSeederService;
        this.formulaOneSeederService = formulaOneSeederService;
        this.videogameCompanySeederService = videogameCompanySeederService;
        this.museumSeederService = museumSeederService;
        this.musicSeederService = musicSeederService;
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
        this.carDealershipSeederService.seedDatabase();
        this.formulaOneSeederService.seedDatabase();
        this.videogameCompanySeederService.seedDatabase();
        this.museumSeederService.seedDatabase();
        this.musicSeederService.seedDatabase();
    }

    public void deleteAll() {
        this.shopSeederService.deleteAll();
        this.zooSeederService.deleteAll();
        this.computerStoreSeederService.deleteAll();
        this.conferenceSeederService.deleteAll();
        this.restaurantSeederService.deleteAll();
        this.carWorkshopSeederService.deleteAll();
        this.foodDeliverySeederService.deleteAll();
        this.carDealershipSeederService.deleteAll();
        this.formulaOneSeederService.deleteAll();
        this.videogameCompanySeederService.deleteAll();
        // this.museumSeederService.deleteAll();
        this.musicSeederService.deleteAll();
    }

    public void reSeedDatabase() {
        this.deleteAll();
        this.seedDatabase();
    }
}
