package es.upm.miw.apaw_practice.adapters.rest.basketball;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.basketball.Basket;
import es.upm.miw.apaw_practice.domain.services.basketball.BasketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(BasketResource.BASKET)
public class BasketResource {
    static final String BASKET = "/basketball/baskets";
    static final String ID = "/{id}";
    static final String UPDATE_DATA = "/update";
    static final String SEARCH = "/search";

    private final BasketService basketService;

    public BasketResource(BasketService basketService) {
        this.basketService = basketService;
    }

    @PatchMapping(ID + UPDATE_DATA)
    public Basket update(@PathVariable String id, @RequestBody Integer value) {
        return this.basketService.updateBasket(id, value);
    }


    @GetMapping(SEARCH)
    public List<String> findIdentifiersByPavilionDirection(@RequestParam String q) {
        String direction = new LexicalAnalyzer().extractWithAssure(q, "direction");
        return this.basketService.findIdentifiersByPavilionDirection(direction);
    }
}