package es.upm.miw.apaw_practice.adapters.rest.coffee_shop;
import es.upm.miw.apaw_practice.domain.models.coffee_shop.Dining;
import es.upm.miw.apaw_practice.domain.services.coffee_shop.DiningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(DiningResource.DINING)
public class DiningResource {
    static final String DINING = "/coffee-shop/dining";
    private final DiningService diningService;

    @Autowired
    public DiningResource(DiningService diningService) {
        this.diningService = diningService;
    }

    @PostMapping
    public Dining create(@RequestBody Dining dining) {
        return this.diningService.Create(dining);
    }
}
