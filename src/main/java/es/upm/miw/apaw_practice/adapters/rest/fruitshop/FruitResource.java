package es.upm.miw.apaw_practice.adapters.rest.fruitshop;

import es.upm.miw.apaw_practice.domain.models.fruitShop.Fruit;
import es.upm.miw.apaw_practice.domain.services.fruitshop.FruitService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(FruitResource.FRUITS)
public class FruitResource {
    static final String FRUITS = "/fruitshop/fruits";
    static final String TYPE = "/{type}";
    static final String UNIT_PRICE = "/age";
    private final FruitService fruitService;

    public FruitResource(FruitService fruitService){
        this.fruitService = fruitService;
    }

    @PutMapping(TYPE + UNIT_PRICE)
    public Fruit putUnitPrice(@PathVariable String type, @RequestBody BigDecimal unitPrice){
        return this.fruitService.updateUnitPrice(type, unitPrice);
    }
}
