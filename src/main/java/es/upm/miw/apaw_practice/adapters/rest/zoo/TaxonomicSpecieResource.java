package es.upm.miw.apaw_practice.adapters.rest.zoo;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.exceptions.BadRequestException;
import es.upm.miw.apaw_practice.domain.models.zoo.TaxonomicSpecie;
import es.upm.miw.apaw_practice.domain.services.zoo.TaxonomicSpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(TaxonomicSpecieResource.TAXONOMICSPECIE)
public class TaxonomicSpecieResource {
    static final String TAXONOMICSPECIE = "/zoo/taxtonomic-species";
    static final String GENUSNAME = "/genusNames";
    static final String SEARCH_BY_VACCINE_NAME = "/search-by-vaccine";

    private final TaxonomicSpecieService taxonomicSpecieService;

    @Autowired
    public TaxonomicSpecieResource(TaxonomicSpecieService taxonomicSpecieService) {
        this.taxonomicSpecieService = taxonomicSpecieService;
    }

    @PostMapping
    public TaxonomicSpecie create(@RequestBody TaxonomicSpecie taxonomicSpecie) {
        return this.taxonomicSpecieService.create(taxonomicSpecie);
    }

    @GetMapping(GENUSNAME + SEARCH_BY_VACCINE_NAME)
    public Stream<String> findByVaccine(@RequestParam String q) {

        String name = new LexicalAnalyzer().extractWithAssure(q, "name");
        if (name.isEmpty()) {
            throw new BadRequestException("q incorrect, expected Vaccine Name");
        }

        return this.taxonomicSpecieService.findByVaccineName(name);
    }

}
