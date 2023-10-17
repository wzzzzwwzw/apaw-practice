package es.upm.miw.apaw_practice.adapters.rest.school;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.school.School;
import es.upm.miw.apaw_practice.domain.services.school.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(SchoolResource.SCHOOLS)
public class SchoolResource {
    static final String SCHOOLS = "/school/schools";

    static final String NAME_ID = "/{name}";
    static final String REGISTRATION_PRICE_SUM_BY_BILINGUAL = "/registration-price-sum-by-bilingual";

    private final SchoolService schoolService;

    @Autowired
    public SchoolResource(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping(NAME_ID)
    public School read(@PathVariable String name) {
        return this.schoolService.read(name);
    }

    @GetMapping(REGISTRATION_PRICE_SUM_BY_BILINGUAL)
    public BigDecimal registrationPriceSumGivenBilingual(@RequestParam String q) {
        Boolean bilingual = new LexicalAnalyzer().extractWithAssure(q, "bilingual", Boolean::parseBoolean);
        return this.schoolService.registrationPriceSumGivenBilingual(bilingual);
    }
}