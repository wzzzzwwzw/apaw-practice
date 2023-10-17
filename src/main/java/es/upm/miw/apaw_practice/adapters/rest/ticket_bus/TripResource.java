package es.upm.miw.apaw_practice.adapters.rest.ticket_bus;

import es.upm.miw.apaw_practice.domain.models.ticket_bus.Trip;
import es.upm.miw.apaw_practice.domain.services.ticket_bus.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TripResource.TRIPS)
public class TripResource {

    public static final String TRIPS = "/ticket_bus/trips";
    public static final String PATH = "/{path}";


    private final TripService tripService;

    @Autowired
    public TripResource(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping(TripResource.PATH)
    public Trip readByPath(@PathVariable String path) {
        return this.tripService.readByPath(path);
    }
}
