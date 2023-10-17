package es.upm.miw.apaw_practice.adapters.rest.ticket_bus;

import es.upm.miw.apaw_practice.domain.exceptions.BadRequestException;
import es.upm.miw.apaw_practice.domain.models.ticket_bus.PassengerAccessModification;
import es.upm.miw.apaw_practice.domain.services.ticket_bus.PassengerBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Component("PassengerResourceTicketBus")
@RestController
@RequestMapping(PassengerResource.PASSENGERS)
public class PassengerResource {
    static final String PASSENGERS = "/ticket_bus/passengers";
    static final String ACCESSIBILITY = "/accessibility";

    private final PassengerBusService passengerBusService;

    @Autowired
    public PassengerResource(PassengerBusService passengerBusService) {
        this.passengerBusService = passengerBusService;
    }

    @PatchMapping(ACCESSIBILITY)
    public void updateAccessPassenger(@RequestBody PassengerAccessModification passengerAccessModification) {
        if (passengerAccessModification.getNewAccess() != null &&
                passengerAccessModification.getOldAccess() != null) {
            this.passengerBusService.updateAccessPassenger(passengerAccessModification);
        } else {
            throw new BadRequestException("Insufficient information.");
        }
    }
}
