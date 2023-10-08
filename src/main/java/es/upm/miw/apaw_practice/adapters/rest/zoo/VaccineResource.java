package es.upm.miw.apaw_practice.adapters.rest.zoo;


import es.upm.miw.apaw_practice.domain.models.zoo.Vaccine;
import es.upm.miw.apaw_practice.domain.services.zoo.VaccineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(VaccineResource.VACCINES)
public class VaccineResource {

    static final String VACCINES = "/zoo/vaccines";

    static final String IDENTIFIER_BATCH = "/{identifierBatch}";

    private final VaccineService vaccineService;

    public VaccineResource(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @GetMapping(IDENTIFIER_BATCH)
    public Vaccine findByIdentifierBatch(@PathVariable String identifierBatch) {
        return this.vaccineService.findByIdentifierBatch(identifierBatch);
    }

}
