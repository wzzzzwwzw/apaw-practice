package es.upm.miw.apaw_practice.adapters.rest.ticket_bus;

import es.upm.miw.apaw_practice.domain.exceptions.BadRequestException;
import es.upm.miw.apaw_practice.domain.models.ticket_bus.Bus;
import es.upm.miw.apaw_practice.domain.services.ticket_bus.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
@RestController
@RequestMapping(BusResource.BUSES)
public class BusResource {

    static final String BUSES = "/ticket_bus/buses";
    static final String REFERENCE_BUS = "/{referenceBus}";
    static final String TRIPS_PATH = "/trips/{path}";

    private final BusService busService;

    @Autowired
    public BusResource(BusService busService) {
        this.busService = busService;
    }

    @PostMapping
    public void create(@RequestBody Bus bus) {
        if (Objects.isNull(bus.getReferenceBus()) ||
                Objects.isNull(bus.getTrip().getPath())) {
            throw new BadRequestException("Incomplete information");
        }
        this.busService.createWithTripPath(bus.getTrip().getPath(), bus);
    }

    @PutMapping(BusResource.REFERENCE_BUS + BusResource.TRIPS_PATH)
    public void updateTrip(@PathVariable("referenceBus") String referenceBus, @PathVariable("path") String tripPath) {
        this.busService.updateTrip(referenceBus, tripPath);
    }
}
