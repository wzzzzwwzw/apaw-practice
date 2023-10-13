package es.upm.miw.apaw_practice.adapters.rest.car_workshop;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.exceptions.BadRequestException;
import es.upm.miw.apaw_practice.domain.models.car_workshop.CarComponent;
import es.upm.miw.apaw_practice.domain.services.car_workshop.CarComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CarComponentResource.CARCOMPONENTS)
public class CarComponentResource {
    static final String CARCOMPONENTS = "/car-workshop/car-components";

    static final String SEARCHSTOCK = "/searchStock";

    private final CarComponentService carComponentService;

    @Autowired
    public CarComponentResource(CarComponentService carComponentService) {
        this.carComponentService = carComponentService;
    }

    @PostMapping
    public CarComponent create(@RequestBody CarComponent carComponent) {
        return this.carComponentService.create(carComponent);
    }

    @GetMapping(SEARCHSTOCK)
    public Integer findTotalStockByIsITVSafe(@RequestParam String q) { // q=isITVSafe:{true/false}
        String isITVSafeString = new LexicalAnalyzer().extractWithAssure(q, "isITVSafe").toLowerCase();
        if (isITVSafeString.equalsIgnoreCase("true") || isITVSafeString.equalsIgnoreCase("false")) {
            Boolean isITVSafe = Boolean.valueOf(isITVSafeString);
            return this.carComponentService.findTotalStockByIsITVSafe(isITVSafe);
        } else {
            throw new BadRequestException("Malformed query parameter: should be true or false");
        }
    }
}
