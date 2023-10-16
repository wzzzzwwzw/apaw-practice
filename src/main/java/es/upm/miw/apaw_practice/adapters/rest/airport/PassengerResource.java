package es.upm.miw.apaw_practice.adapters.rest.airport;

import es.upm.miw.apaw_practice.domain.models.airport.Passenger;
import es.upm.miw.apaw_practice.domain.services.airport.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PassengerResource.PASSENGERS)
public class PassengerResource {

    static final String PASSENGERS = "/airport/passengers";
    static final String NAME_ID = "/{name}";
    private final PassengerService passengerService;

    @Autowired
    public PassengerResource(PassengerService passengerService){
        this.passengerService = passengerService;
    }
    @GetMapping(NAME_ID)
    public Passenger read(@PathVariable String name) {
        return this.passengerService.read(name);
    }

    @PostMapping(NAME_ID)
    public Passenger updateNumberOfPhone(@PathVariable String name, @RequestBody String numberOfPhone){
        return this.passengerService.updateNumberOfPhone(name, numberOfPhone);
    }
}
