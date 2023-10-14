package es.upm.miw.apaw_practice.adapters.rest.formula_one;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.formula_one.EngineManufacturer;
import es.upm.miw.apaw_practice.domain.services.formula_one.EngineManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(EngineManufacturerResource.ENGINE_MANUFACTURERS)
public class EngineManufacturerResource {

    static final String ENGINE_MANUFACTURERS = "/formula-one/engine-manufacturers";
    static final String SEARCH = "/search";

    private final EngineManufacturerService engineManufacturerService;

    @Autowired
    public EngineManufacturerResource(EngineManufacturerService engineManufacturerService) {
        this.engineManufacturerService = engineManufacturerService;
    }

    @PostMapping
    public EngineManufacturer create(@RequestBody EngineManufacturer engineManufacturer) {
        return this.engineManufacturerService.create(engineManufacturer);
    }

    @GetMapping(SEARCH)
    public Stream<String> findManufacturersNamesByHostCountry(@RequestParam String q) { // q=hostCountry:hostCountry
        String hostCountry = new LexicalAnalyzer().extractWithAssure(q, "hostCountry");
        return this.engineManufacturerService.findManufacturersNamesByHostCountry(hostCountry);
    }
}
