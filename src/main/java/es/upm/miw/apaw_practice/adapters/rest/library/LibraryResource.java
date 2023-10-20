package es.upm.miw.apaw_practice.adapters.rest.library;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.library.Library;
import es.upm.miw.apaw_practice.domain.services.library.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(LibraryResource.LIBRARY)
public class LibraryResource {
    static final String LIBRARY = "/library/libraries";
    static final String NAME_ID = "/{name}";
    static final String SEARCH = "/search";
    private final LibraryService libraryService;
    @Autowired
    public LibraryResource(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping(NAME_ID)
    public Library read(@PathVariable String name){
        return this.libraryService.read(name);
    }

    @GetMapping(SEARCH)
    public BigDecimal findAverageOfNumberOfBookByLibraryName(@RequestParam String q){
        String name = new LexicalAnalyzer().extractWithAssure(q, "name");
        return this.libraryService.findAverageOfNumberOfBookByLibraryName(name);
    }
}
