package es.upm.miw.apaw_practice.adapters.rest.stable;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.services.stable.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import es.upm.miw.apaw_practice.domain.models.stable.Horse;

import java.math.BigDecimal;
import java.util.stream.Stream;

@RestController
@RequestMapping(HorseResource.STABLES)
public class HorseResource {
    static final String STABLES = "/horse_stable/stables";

    static final String SEARCH = "/search";

    private final HorseService horseService;

    @Autowired
    public HorseResource(HorseService horseService) {
        this.horseService = horseService;
    }

    @GetMapping(SEARCH)
    public Stream<Horse> findByProviderAndPriceGreaterThan(@RequestParam String q) { // q=price:14000.0
        BigDecimal price = new LexicalAnalyzer().extractWithAssure(q, "price", BigDecimal::new);
        return this.horseService.findByProviderAndPriceGreaterThan(price);
    }
}
