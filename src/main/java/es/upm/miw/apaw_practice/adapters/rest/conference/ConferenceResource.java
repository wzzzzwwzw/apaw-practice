package es.upm.miw.apaw_practice.adapters.rest.conference;

import es.upm.miw.apaw_practice.domain.services.conference.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ConferenceResource.CONFERENCES)
public class ConferenceResource {
    static final String CONFERENCES = "/conference/conferences";
    static final String ID_ID = "/{id}";

    private final ConferenceService conferenceService;

    @Autowired
    public ConferenceResource(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id) {
        this.conferenceService.delete(id);
    }
}
