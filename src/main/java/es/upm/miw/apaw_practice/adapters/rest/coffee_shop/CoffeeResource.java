package es.upm.miw.apaw_practice.adapters.rest.coffee_shop;

import es.upm.miw.apaw_practice.domain.models.coffee_shop.Coffee;
import es.upm.miw.apaw_practice.domain.services.coffee_shop.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CoffeeResource.COFFEES)
public class CoffeeResource {
    static final String COFFEES = "/coffee-shop/coffees";
    static final String NAME = "/{name}";
    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeResource(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping(NAME)
    public Coffee read(@PathVariable String name) {
        return this.coffeeService.read(name);
    }
}
