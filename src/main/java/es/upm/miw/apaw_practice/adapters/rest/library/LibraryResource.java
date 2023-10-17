package es.upm.miw.apaw_practice.adapters.rest.library;

import es.upm.miw.apaw_practice.domain.models.library.Library;
import es.upm.miw.apaw_practice.domain.services.library.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(LibraryResource.LIBRARY)
public class LibraryResource {
    static final String LIBRARY = "/library/libraries";
    static final String NAME_ID = "/{name}";
    private final LibraryService libraryService;
    @Autowired
    public LibraryResource(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping(NAME_ID)
    public Library read(@PathVariable String name){
        return this.libraryService.read(name);
    }
}
