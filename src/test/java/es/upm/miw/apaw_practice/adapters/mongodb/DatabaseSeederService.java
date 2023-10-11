package es.upm.miw.apaw_practice.adapters.mongodb;

import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.CarDealershipSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.CarWorkshopSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.climbing.ClimbingSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.ComputerStoreSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.conference.ConferenceSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.FootballCompetitionSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.film.FilmSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.FormulaOneSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.FurnitureStoreSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.HotelSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.InfluencerAgencySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.MuseumSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.music.MusicSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.OlympicGamesSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.PadelAcademySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.RestaurantSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.shop.ShopSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.subway.SubwaySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.zoo.ZooSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.FoodDeliverySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.VideogameCompanySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.school.SchoolSeederService;
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
    private final FootballCompetitionSeederService footballCompetitionSeederService;
    private final FilmSeederService filmSeederService;
    private final InfluencerAgencySeederService influencerAgencySeederService;
    private final SubwaySeederService subwaySeederService;
    private final SchoolSeederService schoolSeederService;
    private final ClimbingSeederService climbingSeederService;

    private final MusicSeederService musicSeederService;
    private final PadelAcademySeederService padelAcademySeederService;
    private final OlympicGamesSeederService olympicGamesSeederService;
    private final FurnitureStoreSeederService furnitureStoreSeederService;
    private final HotelSeederService hotelSeederService;

    @Autowired
    public DatabaseSeederService(ShopSeederService shopSeederService, ZooSeederService zooSeederService,
                                 ComputerStoreSeederService computerStoreSeederService, ConferenceSeederService conferenceSeederService,
                                 RestaurantSeederService restaurantSeederService, CarWorkshopSeederService carWorkshopSeederService,
                                 FoodDeliverySeederService foodDeliverySeederService,
                                 CarDealershipSeederService carDealershipSeederService, FormulaOneSeederService formulaOneSeederService,
                                 VideogameCompanySeederService videogameCompanySeederService,
                                 MuseumSeederService museumSeederService,
                                 FootballCompetitionSeederService footballCompetitionSeederService,
                                 FilmSeederService filmSeederService, InfluencerAgencySeederService influencerAgencySeederService,
                                 SubwaySeederService subwaySeederService, SchoolSeederService schoolSeederService,
                                 ClimbingSeederService climbingSeederService,
                                 MusicSeederService musicSeederService,
                                 PadelAcademySeederService padelAcademySeederService,
                                 OlympicGamesSeederService olympicGamesSeederService,
                                 FurnitureStoreSeederService furnitureStoreSeederService, HotelSeederService hotelSeederService) {
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
        this.footballCompetitionSeederService = footballCompetitionSeederService;
        this.filmSeederService = filmSeederService;
        this.influencerAgencySeederService = influencerAgencySeederService;
        this.subwaySeederService = subwaySeederService;
        this.schoolSeederService = schoolSeederService;
        this.climbingSeederService = climbingSeederService;
        this.musicSeederService = musicSeederService;
        this.padelAcademySeederService = padelAcademySeederService;
        this.olympicGamesSeederService = olympicGamesSeederService;
        this.furnitureStoreSeederService = furnitureStoreSeederService;
        this.hotelSeederService = hotelSeederService;
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
        this.footballCompetitionSeederService.seedDatabase();
        this.filmSeederService.seedDatabase();
        this.influencerAgencySeederService.seedDatabase();
        this.subwaySeederService.seedDatabase();
        this.schoolSeederService.seedDatabase();
        this.climbingSeederService.seedDatabase();
        this.musicSeederService.seedDatabase();
        this.padelAcademySeederService.seedDatabase();
        this.olympicGamesSeederService.seedDatabase();
        this.furnitureStoreSeederService.seedDatabase();
        this.hotelSeederService.seedDatabase();
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
        this.footballCompetitionSeederService.deleteAll();
        this.filmSeederService.deleteAll();
        this.influencerAgencySeederService.deleteAll();
        this.subwaySeederService.deleteAll();
        this.schoolSeederService.deleteAll();
        this.climbingSeederService.deleteAll();
        this.musicSeederService.deleteAll();
        this.padelAcademySeederService.deleteAll();
        this.olympicGamesSeederService.deleteAll();
        this.furnitureStoreSeederService.deleteAll();
        this.hotelSeederService.deleteAll();
    }

    public void reSeedDatabase() {
        this.deleteAll();
        this.seedDatabase();
    }
}
