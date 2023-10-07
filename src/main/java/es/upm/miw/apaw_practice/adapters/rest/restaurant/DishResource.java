package es.upm.miw.apaw_practice.adapters.rest.restaurant;


import es.upm.miw.apaw_practice.domain.models.restaurant.Dish;
import es.upm.miw.apaw_practice.domain.services.restaurant.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DishResource.DISHES)
public class DishResource {

    static final String DISHES = "/restaurant/dishes";
    static final String TITLE_ID = "/{title}";

    private final DishService dishService;

    @Autowired
    public DishResource(DishService dishService) {
        this.dishService = dishService;
    }

    @PutMapping(TITLE_ID)
    public Dish update(Dish dish) {
        return this.dishService.update(dish);
    }

}
