package es.upm.miw.apaw_practice.adapters.rest.food_delivery;

import es.upm.miw.apaw_practice.adapters.rest.shop.ArticleResource;
import es.upm.miw.apaw_practice.domain.models.food_delivery.Restaurant;
import es.upm.miw.apaw_practice.domain.services.food_delivery.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestaurantResource.RESTAURANTS)
public class RestaurantResource {

    static final String RESTAURANTS = "/food_delivery/restaurants";

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantResource( RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public Restaurant create(@RequestBody Restaurant restaurant){
        return this.restaurantService.create(restaurant);
    }

}
