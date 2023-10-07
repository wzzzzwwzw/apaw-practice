package es.upm.miw.apaw_practice.adapters.rest.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.CategoryRestaurant;
import es.upm.miw.apaw_practice.domain.services.restaurant.CategoryRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CategoryRestaurantResource.CATEGORIES)
public class CategoryRestaurantResource {

    static final String CATEGORIES = "/restaurant/categories";

    private final CategoryRestaurantService categoryRestaurantService;

    @Autowired
    CategoryRestaurantResource(CategoryRestaurantService categoryRestaurantService) {
        this.categoryRestaurantService = categoryRestaurantService;
    }

    @PostMapping
    public CategoryRestaurant create(@RequestBody CategoryRestaurant category) {
        return this.categoryRestaurantService.create(category);
    }

}
