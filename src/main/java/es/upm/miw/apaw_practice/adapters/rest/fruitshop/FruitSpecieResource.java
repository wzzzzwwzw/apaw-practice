package es.upm.miw.apaw_practice.adapters.rest.fruitshop;

import es.upm.miw.apaw_practice.domain.models.fruitShop.FruitSpecie;
import es.upm.miw.apaw_practice.domain.services.fruitshop.FruitSpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(FruitSpecieResource.FRUITSPECIR)
public class FruitSpecieResource {
    static final String FRUITSPECIR = "/fruitshop/fruit-specie";

    private final FruitSpecieService fruitSpecieService;

    @Autowired
    public FruitSpecieResource(FruitSpecieService fruitSpecieService){
        this.fruitSpecieService = fruitSpecieService;
    }

    @PostMapping
    public FruitSpecie create(@RequestBody FruitSpecie fruitSpecie){
        return  this.fruitSpecieService.create(fruitSpecie);
    }

}
