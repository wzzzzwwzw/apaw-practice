package es.upm.miw.apaw_practice.adapters.rest.film;

import es.upm.miw.apaw_practice.domain.models.film.Review;
import es.upm.miw.apaw_practice.domain.services.film.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(FilmResource.FILMS)
public class FilmResource {
    static final String FILMS = "/film/films";

    static final String ID_ID = "/{id}";
    static final String REVIEWS = "/reviews";

    private final FilmService filmService;

    @Autowired
    public FilmResource(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping(ID_ID + REVIEWS)
    public List<Review> getReviews(@PathVariable String id) {
        return this.filmService.getReviews(id);
    }
}
