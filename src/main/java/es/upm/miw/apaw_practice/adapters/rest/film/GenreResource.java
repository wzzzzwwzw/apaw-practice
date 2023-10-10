package es.upm.miw.apaw_practice.adapters.rest.film;

import es.upm.miw.apaw_practice.domain.services.film.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GenreResource.GENRES)
public class GenreResource {
    static final String GENRES = "/film/genres";

    static final String NAME_ID = "/{name}";

    private final GenreService genreService;

    @Autowired
    public GenreResource(GenreService genreService) {
        this.genreService = genreService;
    }

    @DeleteMapping(NAME_ID)
    public void delete(@PathVariable String name) {
        this.genreService.delete(name);
    }
}
