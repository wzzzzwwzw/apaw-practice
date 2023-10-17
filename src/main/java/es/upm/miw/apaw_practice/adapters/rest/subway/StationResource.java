package es.upm.miw.apaw_practice.adapters.rest.subway;

import es.upm.miw.apaw_practice.domain.models.subway.Station;
import es.upm.miw.apaw_practice.domain.services.subway.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(StationResource.STATIONS)
public class StationResource {

    static final String STATIONS = "/subway/stations";

    static final String NAME_ID = "/{name}";

    private final StationService stationService;

    @Autowired
    public StationResource(StationService stationService) {
        this.stationService = stationService;
    }

    @PostMapping
    public Station create(@RequestBody Station station) {
        return this.stationService.create(station);
    }

    @GetMapping(NAME_ID)
    public Station read(@PathVariable String name) {
        return this.stationService.readByName(name);
    }

    @DeleteMapping(NAME_ID)
    public void delete(@PathVariable String name) {
        this.stationService.delete(name);
    }

}
