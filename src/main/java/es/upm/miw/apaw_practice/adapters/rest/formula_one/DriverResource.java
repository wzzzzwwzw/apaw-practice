package es.upm.miw.apaw_practice.adapters.rest.formula_one;

import es.upm.miw.apaw_practice.domain.services.formula_one.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DriverResource.DRIVERS)
public class DriverResource {

    static final  String DRIVERS = "/formula-one/drivers";

    private final DriverService driverService;

    @Autowired
    public DriverResource(DriverService driverService) {
        this.driverService = driverService;
    }
}
