package es.upm.miw.apaw_practice.adapters.rest.car_dealership;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.services.car_dealership.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(CarResource.CARS)
public class CarResource {
    static final String CARS = "/car-dealership/cars";
    static final String CHASSIS_ID = "/{chassis}";
    static final String CAR_MODEL = "/car-model";
    static final String NAME ="/name";
    static final String SEARCH = "/search";

    private final CarService carService;

    @Autowired
    public CarResource(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(CHASSIS_ID + CAR_MODEL + NAME)
    public String readCarModelName(@PathVariable String chassis) {
        return this.carService.readCarModelName(chassis);
    }

    @GetMapping(SEARCH)
    public BigDecimal findAverageCarPriceByName(@RequestParam String q) { //q=name:name
        String name = new LexicalAnalyzer().extractWithAssure(q, "name");
        return this.carService.findAverageCarPriceByName(name);
    }
}
