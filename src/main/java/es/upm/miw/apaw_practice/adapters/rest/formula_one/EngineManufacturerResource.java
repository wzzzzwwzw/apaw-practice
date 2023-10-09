package es.upm.miw.apaw_practice.adapters.rest.formula_one;

import es.upm.miw.apaw_practice.domain.models.formula_one.EngineManufacturer;
import es.upm.miw.apaw_practice.domain.services.formula_one.EngineManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EngineManufacturerResource.ENGINE_MANUFACTURERS)
public class EngineManufacturerResource {

    static final String ENGINE_MANUFACTURERS = "/formula-one/engine-manufacturers";

    private final EngineManufacturerService engineManufacturerService;

    @Autowired
    public EngineManufacturerResource(EngineManufacturerService engineManufacturerService) {
        this.engineManufacturerService = engineManufacturerService;
    }

    @PostMapping
    public EngineManufacturer create(@RequestBody EngineManufacturer engineManufacturer) {
        return this.engineManufacturerService.create(engineManufacturer);
    }
}
