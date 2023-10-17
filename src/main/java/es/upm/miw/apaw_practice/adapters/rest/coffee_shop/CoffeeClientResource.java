package es.upm.miw.apaw_practice.adapters.rest.coffee_shop;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.coffee_shop.CoffeeClient;
import es.upm.miw.apaw_practice.domain.services.coffee_shop.CoffeeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(CoffeeClientResource.COFFEES)
public class CoffeeClientResource {
    static final String COFFEES = "/coffee-shop/coffees-clients";
    static final String NAME = "/{name}";
    static final String TOTAL_PRICE = "/total-price";
    static final String UNIQUE_LOCATION = "/unique-location";
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

    @GetMapping(TOTAL_PRICE)
    public BigDecimal getTotalPriceByCategory(@RequestParam String q) {
        String coffeeCategory = new LexicalAnalyzer().extractWithAssure(q, "category");
        return this.coffeeClientService.getTotalPriceByCategory(coffeeCategory);
    }

    @GetMapping(UNIQUE_LOCATION)
    public List<String> getUniqueLocationsByCoffee(@RequestParam String q) {
        String coffee = new LexicalAnalyzer().extractWithAssure(q, "coffee");
        return this.coffeeClientService.getUniqueLocationsByCoffee(coffee);
    }
}
