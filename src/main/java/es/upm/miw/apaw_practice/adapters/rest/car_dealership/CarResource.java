package es.upm.miw.apaw_practice.adapters.rest.car_dealership;

import es.upm.miw.apaw_practice.domain.models.car_dealership.Car;
import es.upm.miw.apaw_practice.domain.services.car_dealership.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CarResource.CARS)
public class CarResource {
    static final String CARS = "/car-dealership/cars";
    static final String CHASSIS_ID = "/{chassis}";
    static final String CAR_MODEL = "/car-model";
    static final String NAME ="/name";

    private final CarService carService;

    @Autowired
    public CarResource(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(CHASSIS_ID + CAR_MODEL + NAME)
    public String read(@PathVariable String chassis) {
        return this.carService.readCarModelName(chassis);
    }
}
