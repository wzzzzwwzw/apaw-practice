package es.upm.miw.apaw_practice.adapters.rest.conference;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.conference.Paper;
import es.upm.miw.apaw_practice.domain.services.conference.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PaperResource.PAPERS)
public class PaperResource {
    static final String PAPERS = "/conference/papers";

    static final String DIGITAL_OBJECT_IDENTIFIER_ID = "/{digitalObjectIdentifier}";

    static final String PAPER_TITLE = "/title";

    static final String SEARCH = "/search";

    private final PaperService paperService;

    @Autowired
    public PaperResource(PaperService paperService) {
        this.paperService = paperService;
    }

    @GetMapping(DIGITAL_OBJECT_IDENTIFIER_ID)
    public Paper read(@PathVariable String digitalObjectIdentifier) {
        return this.paperService.read(digitalObjectIdentifier);
    }

    @PutMapping(DIGITAL_OBJECT_IDENTIFIER_ID + PAPER_TITLE)
    public Paper updatePaperTitle(@PathVariable String digitalObjectIdentifier, @RequestBody String title) {
        return this.paperService.updatePaperTitle(digitalObjectIdentifier, title);
    }

    @GetMapping(SEARCH)
    public Integer findTotalLengthByConferenceLocationHall(@RequestParam String q) { // q=hall:hall
        String hall = new LexicalAnalyzer().extractWithAssure(q, "hall");
        return this.paperService.findTotalLengthByConferenceLocationHall(hall);
    }
}
