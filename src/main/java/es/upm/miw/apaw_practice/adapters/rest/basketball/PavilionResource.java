package es.upm.miw.apaw_practice.adapters.rest.basketball;

import es.upm.miw.apaw_practice.domain.models.basketball.Pavilion;
import es.upm.miw.apaw_practice.domain.services.basketball.PavilionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PavilionResource.PAVILION)
public class PavilionResource {
    static final String PAVILION = "/basketball/pavilion";
    private final PavilionService pavilionService;

    @Autowired
    public PavilionResource(PavilionService pavilionService) {
        this.pavilionService = pavilionService;
    }

    @PostMapping
    public Pavilion create(@RequestBody Pavilion pavilion) {
        return this.pavilionService.create(pavilion);
    }
}