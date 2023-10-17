package es.upm.miw.apaw_practice.adapters.rest.fruitshop;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.exceptions.BadRequestException;
import es.upm.miw.apaw_practice.domain.models.fruitShop.FruitSpecie;
import es.upm.miw.apaw_practice.domain.services.fruitshop.FruitSpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(FruitSpecieResource.FRUITSPECIE)
public class FruitSpecieResource {
    static final String FRUITSPECIE = "/fruitshop/fruit-specie";
    static final String SEASON = "/season";
    static final String SEARCH_BY_CUSTOMER_PHONE = "/search-by-phone";
    private final FruitSpecieService fruitSpecieService;

    @Autowired
    public FruitSpecieResource(FruitSpecieService fruitSpecieService){
        this.fruitSpecieService = fruitSpecieService;
    }

    @PostMapping
    public FruitSpecie create(@RequestBody FruitSpecie fruitSpecie){
        return  this.fruitSpecieService.create(fruitSpecie);
    }

    @GetMapping(SEASON + SEARCH_BY_CUSTOMER_PHONE)
    public Stream<String> findSeasonByTropicalFruitAndByPhone(@RequestParam String q){
        String phone = new LexicalAnalyzer().extractWithAssure(q,"phone");
        if(phone.isEmpty()){
            throw new BadRequestException("q incorrect, expected Customer phone");
        }
        return this.fruitSpecieService.findByTropicalFruitAndByPhone(phone);
    }


}
