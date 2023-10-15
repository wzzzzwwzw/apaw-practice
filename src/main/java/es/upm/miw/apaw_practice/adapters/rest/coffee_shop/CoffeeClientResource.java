package es.upm.miw.apaw_practice.adapters.rest.coffee_shop;

import es.upm.miw.apaw_practice.domain.models.coffee_shop.CoffeeClient;
import es.upm.miw.apaw_practice.domain.services.coffee_shop.CoffeeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CoffeeClientResource.COFFEES)
public class CoffeeClientResource {
    static final String COFFEES = "/coffee-shop/coffees-clients";
    static final String NAME = "/{name}";
    @Autowired
    private final CoffeeClientService coffeeClientService;

    public CoffeeClientResource(CoffeeClientService coffeeClientService) {
        this.coffeeClientService = coffeeClientService;
    }

    @DeleteMapping(NAME)
    public void delete(@PathVariable String name) {
        this.coffeeClientService.delete(name);
    }

    @PatchMapping(NAME)
    public CoffeeClient updateAddressByName(@PathVariable String name) {
        return this.coffeeClientService.updateAddressByName(name);
    }
}
