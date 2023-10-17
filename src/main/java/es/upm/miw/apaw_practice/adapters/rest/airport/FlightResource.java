package es.upm.miw.apaw_practice.adapters.rest.airport;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.airport.Flight;
import es.upm.miw.apaw_practice.domain.services.airport.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(FlightResource.FLIGHTS)
public class FlightResource {
    static final String FLIGHTS = "/airport/flights";
    static final String SEARCH_AGE = "/search/average-age";
    static final String SEARCH_AIRLINE = "/search/airline-name";
    private final FlightService flightService;

    @Autowired
    public FlightResource(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public Flight create(@RequestBody Flight flight) {
        return this.flightService.create(flight);
    }
    @GetMapping(SEARCH_AIRLINE)
    public Stream<String> findAirlineNameByPassengerAgeGreaterThan(@RequestParam Integer q) {
        return this.flightService.findAirlineNameByPassengerAgeGreaterThan(q);
    }
    @GetMapping(SEARCH_AGE)
    public Double findAverageAgeByModel(String q){//q=model:model
        return this.flightService.findAverageAgeByModel(q);
    }

}
