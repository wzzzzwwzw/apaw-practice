package es.upm.miw.apaw_practice.adapters.rest.basketball;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.basketball.Pavilion;
import es.upm.miw.apaw_practice.domain.services.basketball.PavilionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(PavilionResource.PAVILION)
public class PavilionResource {
    static final String PAVILION = "/basketball/pavilion";
    static final String SEARCH = "/search";
    private final PavilionService pavilionService;

    @Autowired
    public PavilionResource(PavilionService pavilionService) {
        this.pavilionService = pavilionService;
    }

    @PostMapping
    public Pavilion create(@RequestBody Pavilion pavilion) {
        return this.pavilionService.create(pavilion);
    }

    @GetMapping(SEARCH)
    public BigDecimal findAvgOfTotalCapacityByBasketValue(@RequestParam String q) {
        Integer value = new LexicalAnalyzer().extractWithAssure(q, "value", Integer::parseInt);
        return this.pavilionService.findAvgOfTotalCapacityByBasketValue(value);
    }
}