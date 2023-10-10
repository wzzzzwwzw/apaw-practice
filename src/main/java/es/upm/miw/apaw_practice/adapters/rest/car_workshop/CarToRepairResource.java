package es.upm.miw.apaw_practice.adapters.rest.car_workshop;

import es.upm.miw.apaw_practice.domain.models.car_workshop.CarToRepair;
import es.upm.miw.apaw_practice.domain.services.car_workshop.CarToRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CarToRepairResource.CARSTOREPAIR)
public class CarToRepairResource {
    static final String CARSTOREPAIR = "/car-workshop/cars-to-repair";
    static final String REGISTRATIONNUMBER_ID = "/{registrationNumber}";
    static final String MODEL = "/model";

    private final CarToRepairService carToRepairService;

    @Autowired
    public CarToRepairResource(CarToRepairService carToRepairService) {
        this.carToRepairService = carToRepairService;
    }

    @PutMapping(REGISTRATIONNUMBER_ID + MODEL)
    public CarToRepair updateModel(@PathVariable String registrationNumber, @RequestBody String model) {
        return this.carToRepairService.updateModel(registrationNumber, model);
    }

}
