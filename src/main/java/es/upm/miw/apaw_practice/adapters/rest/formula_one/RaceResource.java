package es.upm.miw.apaw_practice.adapters.rest.formula_one;

import es.upm.miw.apaw_practice.domain.services.formula_one.RaceService;
import es.upm.miw.apaw_practice.domain.services.restaurant.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RaceResource.RACES)
public class RaceResource {

    static final String RACES = "/formula-one/races";

    private final RaceService raceService;

    @Autowired
    public RaceResource(RaceService raceService) {
        this.raceService = raceService;
    }
}
