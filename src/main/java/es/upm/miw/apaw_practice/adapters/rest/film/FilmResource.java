package es.upm.miw.apaw_practice.adapters.rest.film;

import es.upm.miw.apaw_practice.domain.models.film.Film;
import es.upm.miw.apaw_practice.domain.services.film.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(FilmResource.FILMS)
public class FilmResource {
    static final String FILMS = "/film/films";

    static final String TITLE_ID = "/{title}";

    private final FilmService filmService;

    @Autowired
    public FilmResource(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping(TITLE_ID)
    public Stream<Film> read(@PathVariable String title) {
        return this.filmService.read(title);
    }
}
