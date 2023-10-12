package es.upm.miw.apaw_practice.adapters.rest.formula_one;

import es.upm.miw.apaw_practice.domain.models.formula_one.Driver;
import es.upm.miw.apaw_practice.domain.services.formula_one.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(DriverResource.DRIVERS)
public class DriverResource {

    static final String DRIVERS = "/formula-one/drivers";
    static final String NUMBER_ID = "/{number}";

    private final DriverService driverService;

    @Autowired
    public DriverResource(DriverService driverService) {
        this.driverService = driverService;
    }

    @PatchMapping(NUMBER_ID)
    public Driver updatePoints(@PathVariable Integer number, @RequestBody Float points) {
        return this.driverService.updatePoints(number, points);
    }
}
