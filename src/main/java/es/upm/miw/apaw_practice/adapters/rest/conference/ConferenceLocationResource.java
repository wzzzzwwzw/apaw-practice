package es.upm.miw.apaw_practice.adapters.rest.conference;

import es.upm.miw.apaw_practice.domain.models.conference.ConferenceLocation;
import es.upm.miw.apaw_practice.domain.services.conference.ConferenceLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ConferenceLocationResource.CONFERENCE_LOCATIONS)
public class ConferenceLocationResource {
    static final String CONFERENCE_LOCATIONS = "/shop/conference-locations";

    static final String ID_ID = "/{id}";

    private final ConferenceLocationService conferenceLocationService;

    @Autowired
    public ConferenceLocationResource(ConferenceLocationService conferenceLocationService) {
        this.conferenceLocationService = conferenceLocationService;
    }

    @PatchMapping(ID_ID)
    public ConferenceLocation updateHall(@PathVariable String id, @RequestBody String hall) {
        return this.conferenceLocationService.updateHall(id, hall);
    }

}
