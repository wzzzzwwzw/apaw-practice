package es.upm.miw.apaw_practice.adapters.rest.airport;

import es.upm.miw.apaw_practice.domain.models.airport.AirLine;
import es.upm.miw.apaw_practice.domain.models.airport.Aircraft;
import es.upm.miw.apaw_practice.domain.models.shop.ArticleItem;
import es.upm.miw.apaw_practice.domain.models.shop.ShoppingCart;
import es.upm.miw.apaw_practice.domain.services.airport.AirLineService;
import es.upm.miw.apaw_practice.domain.services.shop.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AirLineResource.AIRLINES)
public class AirLineResource {
    static final String AIRLINES = "/airport/airline";

    static final String NAME = "/{name}";
    static final String AIRCRAFTS = "/aircrafts";
    private final AirLineService airLineService;

    @Autowired
    public AirLineResource(AirLineService airLineService) {
        this.airLineService = airLineService;
    }
    @PutMapping(NAME + AIRCRAFTS)
    public AirLine updateArticleItems(@PathVariable String name, @RequestBody List<Aircraft> aircraftList) {
        return this.airLineService.updateAircrafts(name, aircraftList);
    }
}
