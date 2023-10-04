package es.upm.miw.apaw_practice.adapters.mongodb.food_delivery;

import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.daos.ClientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.daos.OrderRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.daos.RestaurantRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.daos.TransportRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.entities.ClientEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.entities.OrderEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.entities.RestaurantEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.entities.TransportEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class FoodDeliverySeederService {

    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private TransportRepository transportRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Food Delivery Initial Load -----------");
        RestaurantEntity[] restaurants = {
                new RestaurantEntity("La Pizzeria", "Italian", "Authentic Italian pizza", "123 Calle de Gran Vía", 50),
                new RestaurantEntity("Sushi Palace", "Japanese", "Variety of fresh sushi", "456 Calle de Fuencarral", 40),
                new RestaurantEntity("Burger Haven", "American", "Juicy burgers", "789 Calle de Preciados", 30),
                new RestaurantEntity("Taco Fiesta", "Mexican", "Delicious tacos and burritos", "101 Calle Mayor", 35),
                new RestaurantEntity("Mediterranean Flavors", "Mediterranean", "Delight in Mediterranean dishes", "234 Calle de Alcalá, Madrid", 45),
                new RestaurantEntity("Asian Fusion", "Asian", "Experience a fusion of Asian cuisines", "567 Calle de Serrano, Madrid", 35)
        };
        this.restaurantRepository.saveAll(Arrays.asList(restaurants));
        TransportEntity[] transports = {
                new TransportEntity("T001", true, new BigDecimal("50.0"), "ABC123", Arrays.asList(restaurants[0], restaurants[1])),
                new TransportEntity("T002", true, new BigDecimal("40.0"), "XYZ789", Arrays.asList(restaurants[2], restaurants[3], restaurants[4])),
                new TransportEntity("T003", true, new BigDecimal("35.0"), "DEF456", Arrays.asList(restaurants[5]))
        };
        this.transportRepository.saveAll(Arrays.asList(transports));
        OrderEntity[] orders = {
                new OrderEntity(1,new BigDecimal("25.0"), false, new BigDecimal("2.5"), "Credit Card", restaurants[0], transports[0]),
                new OrderEntity(2, new BigDecimal("30.0"), true, new BigDecimal("3.0"), "PayPal", restaurants[1], transports[0]),
                new OrderEntity(3, new BigDecimal("40.0"), false, new BigDecimal("4.5"),"Cash", restaurants[2], transports[1]),
                new OrderEntity(4, new BigDecimal("22.0"), true, new BigDecimal("2.0"), "Credit Card", restaurants[3], transports[1]),
                new OrderEntity(5, new BigDecimal("35.0"), false, new BigDecimal("3.8"), "PayPal", restaurants[5], transports[2])
        };
        this.orderRepository.saveAll(Arrays.asList(orders));
        ClientEntity[] clients = {
                new ClientEntity("ID001", "customer1@example.com", "123456789", Arrays.asList(orders[0],orders[1])),
                new ClientEntity("ID002", "customer2@example.com", "987654321", Arrays.asList(orders[2], orders[3], orders[4]))
        };
        this.clientRepository.saveAll(Arrays.asList(clients));
    }


    public void deleteAll() {
        this.restaurantRepository.deleteAll();
        this.clientRepository.deleteAll();
        this.orderRepository.deleteAll();
        this.transportRepository.deleteAll();
    }
}
