package es.upm.miw.apaw_practice.adapters.rest.conference;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.conference.ConferenceLocation;
import es.upm.miw.apaw_practice.domain.services.conference.ConferenceLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(ConferenceLocationResource.CONFERENCE_LOCATIONS)
public class ConferenceLocationResource {
    static final String CONFERENCE_LOCATIONS = "/shop/conference-locations";

    static final String ID_ID = "/{id}";

    static final String SEARCH = "/search";

    private final ConferenceLocationService conferenceLocationService;

    @Autowired
    public ConferenceLocationResource(ConferenceLocationService conferenceLocationService) {
        this.conferenceLocationService = conferenceLocationService;
    }

    @PatchMapping(ID_ID)
    public ConferenceLocation updateHall(@PathVariable String id, @RequestBody String hall) {
        return this.conferenceLocationService.updateHall(id, hall);
    }

    @GetMapping(SEARCH)
    public Stream<String> findCitiesByAuthorHonorific(@RequestParam String q) { // q=honorific:honorific
        String honorific = new LexicalAnalyzer().extractWithAssure(q, "honorific");
        return this.conferenceLocationService.findCitiesByAuthorHonorific(honorific);
    }
}
