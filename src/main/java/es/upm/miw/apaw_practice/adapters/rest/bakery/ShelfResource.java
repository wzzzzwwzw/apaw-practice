package es.upm.miw.apaw_practice.adapters.rest.bakery;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.bakery.Shelf;
import es.upm.miw.apaw_practice.domain.services.bakery.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(ShelfResource.SHELVES)
public class ShelfResource {
    static final String SHELVES = "/bakery/shelves";
    static final String NAME_ID = "/{name}";
    static final String SEARCH = "/search";

    private final ShelfService shelfService;

    @Autowired
    public ShelfResource(ShelfService shelfService) {
        this.shelfService = shelfService;
    }

    @PutMapping(NAME_ID)
    public Shelf update(@PathVariable String name, @RequestBody Shelf shelf) {
        return this.shelfService.update(name, shelf);
    }

    @GetMapping(SEARCH)
    public Stream<String> findUniqueLocationsByProductTypeCode(@RequestParam String q) {
        String code = new LexicalAnalyzer().extractWithAssure(q, "code");
        return this.shelfService.findUniqueLocationsByProductTypeCode(code);
    }
}