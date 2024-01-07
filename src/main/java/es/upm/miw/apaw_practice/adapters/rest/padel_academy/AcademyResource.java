package es.upm.miw.apaw_practice.adapters.rest.padel_academy;

import es.upm.miw.apaw_practice.domain.models.padel_academy.Academy;
import es.upm.miw.apaw_practice.domain.services.padel_academy.AcademyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AcademyResource.ACADEMIES)
public class AcademyResource {
    static final String ACADEMIES = "/padel-academy/academy";
    static final String NAME = "/{name}";
    private final AcademyService academyService;

    @Autowired
    public AcademyResource(AcademyService academyService) {
        this.academyService = academyService;
    }

    @GetMapping(NAME)
    public Academy read(@PathVariable String name) {return this.academyService.read(name);}
}
