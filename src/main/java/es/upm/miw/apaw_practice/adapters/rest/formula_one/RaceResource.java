package es.upm.miw.apaw_practice.adapters.rest.formula_one;

import es.upm.miw.apaw_practice.domain.models.formula_one.Race;
import es.upm.miw.apaw_practice.domain.services.formula_one.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RaceResource.RACES)
public class RaceResource {

    static final String RACES = "/formula-one/races";
    static final String CIRCUIT_NAME_ID = "/{circuitName}";

    private final RaceService raceService;

    @Autowired
    public RaceResource(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping(CIRCUIT_NAME_ID)
    public Race findByCircuitName(@PathVariable String circuitName) {
        return this.raceService.findByCircuitName(circuitName);
    }
}
