package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.domain.services.museum.ExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ExhibitionResource.EXHIBITIONS)
public class ExhibitionResource {
    static final String EXHIBITIONS = "/museum/exhibitions";
    static final String NAME_ID = "/{exhibitionName}";

    private final ExhibitionService exhibitionService;

    @Autowired
    public ExhibitionResource(ExhibitionService exhibitionService) {
        this.exhibitionService = exhibitionService;
    }

    @DeleteMapping(NAME_ID)
    public void delete(@PathVariable String exhibitionName) {
        this.exhibitionService.delete(exhibitionName);
    }
}
