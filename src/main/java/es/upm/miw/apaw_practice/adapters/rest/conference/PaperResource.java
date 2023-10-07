package es.upm.miw.apaw_practice.adapters.rest.conference;

import es.upm.miw.apaw_practice.domain.models.conference.Paper;
import es.upm.miw.apaw_practice.domain.services.conference.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PaperResource.PAPERS)
public class PaperResource {
    static final String PAPERS = "/conference/papers";

    static final String DIGITAL_OBJECT_IDENTIFIER_ID = "/{digitalObjectIdentifier}";

    private final PaperService paperService;

    @Autowired
    public PaperResource(PaperService paperService) {
        this.paperService = paperService;
    }

    @GetMapping(DIGITAL_OBJECT_IDENTIFIER_ID)
    public Paper read(@PathVariable String digitalObjectIdentifier) {
        return this.paperService.read(digitalObjectIdentifier);
    }
}
