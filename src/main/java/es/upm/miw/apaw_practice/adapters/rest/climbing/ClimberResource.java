package es.upm.miw.apaw_practice.adapters.rest.climbing;

import es.upm.miw.apaw_practice.domain.models.climbing.Climber;
import es.upm.miw.apaw_practice.domain.services.climbing.ClimberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ClimberResource.CLIMBERS)
public class ClimberResource {

    static final String CLIMBERS = "/shop/climbers";

    static final String EMAIL_ID = "/{email}";

    private final ClimberService climberService;

    @Autowired
    public ClimberResource(ClimberService climberService) {
        this.climberService = climberService;
    }

    @GetMapping(EMAIL_ID)
    public Climber read(@PathVariable String email) {
        return this.climberService.read(email);
    }

}
