package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.museum.Exhibition;
import es.upm.miw.apaw_practice.domain.services.museum.ExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(ExhibitionResource.EXHIBITIONS)
public class ExhibitionResource {
    static final String EXHIBITIONS = "/museum/exhibitions";
    static final String SEARCH = "/search";
    static final String NAME_ID = "/{exhibitionName}";

    private final ExhibitionService exhibitionService;

    @Autowired
    public ExhibitionResource(ExhibitionService exhibitionService) {
        this.exhibitionService = exhibitionService;
    }

    @GetMapping(SEARCH)
    public Stream<String> findLocationsByArtWorkExhibitedOfPainterBySurname(@RequestParam String q) {
        String painterSurname = new LexicalAnalyzer().extractWithAssure(q, "surname");
        return this.exhibitionService.findByArtWorkExhibitedOfPainterBySurname(painterSurname)
                .map(Exhibition::getLocation)
                .distinct();
    }

    @DeleteMapping(NAME_ID)
    public void delete(@PathVariable String exhibitionName) {
        this.exhibitionService.delete(exhibitionName);
    }
}
