package es.upm.miw.apaw_practice.adapters.rest.car_workshop;

import es.upm.miw.apaw_practice.domain.models.car_workshop.CarComponent;
import es.upm.miw.apaw_practice.domain.services.car_workshop.CarComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CarComponentResource.CARCOMPONENTS)
public class CarComponentResource {
    static final String CARCOMPONENTS = "/car-components";

    private final CarComponentService carComponentService;

    @Autowired
    public CarComponentResource(CarComponentService carComponentService) {
        this.carComponentService = carComponentService;
    }

    @PostMapping
    public CarComponent create(@RequestBody CarComponent carComponent) {
        return this.carComponentService.create(carComponent);
    }
}
