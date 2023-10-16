package es.upm.miw.apaw_practice.adapters.rest.coffee_shop;

import es.upm.miw.apaw_practice.domain.models.coffee_shop.Coffee;
import es.upm.miw.apaw_practice.domain.models.computer_store.Monitor;
import es.upm.miw.apaw_practice.domain.services.coffee_shop.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(CoffeeResource.COFFEES)
public class CoffeeResource {
    static final String COFFEES = "/coffee-shop/coffees";
    static final String NAME = "/{name}";
    static final String UPDATE_DATA = "/update";
    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeResource(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping(NAME)
    public Coffee read(@PathVariable String name) {
        return this.coffeeService.read(name);
    }

    @PutMapping(NAME + UPDATE_DATA)
    public Coffee update(@PathVariable String name, @RequestBody BigDecimal price) {
        return this.coffeeService.updateCoffee(name, price);
    }
}
