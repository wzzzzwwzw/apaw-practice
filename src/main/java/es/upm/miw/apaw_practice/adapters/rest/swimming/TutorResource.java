package es.upm.miw.apaw_practice.adapters.rest.swimming;

import es.upm.miw.apaw_practice.domain.models.swimming.Tutor;
import es.upm.miw.apaw_practice.domain.services.swimming.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TutorResource.TUTORS)
public class TutorResource {

    static final String TUTORS = "/swimming/tutors";
    static final String APPELLATION_ID = "/{appellation}";
    private final TutorService tutorService;

    @Autowired
    public TutorResource(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping(APPELLATION_ID)
    public Tutor read(@PathVariable String appellation) {
        return this.tutorService.readByAppellation(appellation);
    }
}
