package es.upm.miw.apaw_practice.adapters.rest.influencer_agency;

import es.upm.miw.apaw_practice.domain.services.influencer_agency.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AgencyResource.AGENCIES)
public class AgencyResource {
    public static final String AGENCIES = "/influencer-agency/agencies";
    public static final String NAME_ID = "/{name}";

    private final AgencyService agencyService;

    @Autowired
    public AgencyResource(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @DeleteMapping(NAME_ID)
    public void deleteAgenciesStartingWith(@PathVariable String name) {
        this.agencyService.deleteAgenciesStartingWith(name);
    }
}