package es.upm.miw.apaw_practice.adapters.rest.school;

import es.upm.miw.apaw_practice.domain.models.school.School;
import es.upm.miw.apaw_practice.domain.services.school.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(SchoolResource.SCHOOLS)
public class SchoolResource {
    static final String SCHOOLS = "/school/schools";

    static final String NAME_ID = "/{name}";

    private final SchoolService schoolService;

    @Autowired
    public SchoolResource(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping(NAME_ID)
    public School read(@PathVariable String name) {
        return this.schoolService.read(name);
    }
}