package es.upm.miw.apaw_practice.adapters.rest.formula_one;

import es.upm.miw.apaw_practice.domain.services.formula_one.EngineManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EngineManufacturerResource.ENGINE_MANUFACTURERS)
public class EngineManufacturerResource {

    static final String ENGINE_MANUFACTURERS = "/formula-one/engine-manufacturers";

    private final EngineManufacturerService enginemanufacturerService;

    @Autowired
    public EngineManufacturerResource(EngineManufacturerService enginemanufacturerService) {
        this.enginemanufacturerService = enginemanufacturerService;
    }
}
