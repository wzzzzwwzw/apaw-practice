package es.upm.miw.apaw_practice.adapters.rest.zoo;

import es.upm.miw.apaw_practice.domain.models.zoo.TaxonomicSpecie;
import es.upm.miw.apaw_practice.domain.services.zoo.TaxonomicSpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TaxonomicSpecieResource.TAXONOMICSPECIE)
public class TaxonomicSpecieResource {
    static final String TAXONOMICSPECIE = "/zoo/taxtonomic-species";

    private final TaxonomicSpecieService taxonomicSpecieService;

    @Autowired
    public TaxonomicSpecieResource(TaxonomicSpecieService taxonomicSpecieService) {
        this.taxonomicSpecieService = taxonomicSpecieService;
    }

    @PostMapping
    public TaxonomicSpecie create(@RequestBody TaxonomicSpecie taxonomicSpecie) {
        return this.taxonomicSpecieService.create(taxonomicSpecie);
    }

}
