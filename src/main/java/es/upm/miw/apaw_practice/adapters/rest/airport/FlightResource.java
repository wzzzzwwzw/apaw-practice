package es.upm.miw.apaw_practice.adapters.rest.airport;

import es.upm.miw.apaw_practice.domain.models.airport.Flight;
import es.upm.miw.apaw_practice.domain.services.airport.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(FlightResource.FLIGHTS)
public class FlightResource {
    static final String FLIGHTS = "/airport/flights";
    private final FlightService flightService;

    @Autowired
    public FlightResource(FlightService flightService){
        this.flightService = flightService;
    }

    @PostMapping
    public Flight create(@RequestBody Flight flight) {
            return this.flightService.create(flight);
    }
}
