package es.upm.miw.apaw_practice.adapters.rest.formula_one;

import es.upm.miw.apaw_practice.domain.models.formula_one.Race;
import es.upm.miw.apaw_practice.domain.services.formula_one.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RaceResource.RACES)
public class RaceResource {

    static final String RACES = "/formula-one/races";
    static final String CIRCUIT_NAME_ID = "/{circuitName}";
    static final String LAPS = "/laps";

    private final RaceService raceService;

    @Autowired
    public RaceResource(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping(CIRCUIT_NAME_ID)
    public Race read(@PathVariable String circuitName) {
        return this.raceService.read(circuitName);
    }

    @PutMapping(CIRCUIT_NAME_ID + LAPS)
    public Race updateLaps(@PathVariable String circuitName, @RequestBody Integer laps) {
        return this.raceService.updateLaps(circuitName, laps);
    }
}
