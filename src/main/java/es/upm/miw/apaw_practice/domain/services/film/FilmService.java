package es.upm.miw.apaw_practice.domain.services.film;

import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.film.Film;
import es.upm.miw.apaw_practice.domain.models.film.Review;
import es.upm.miw.apaw_practice.domain.persistence_ports.film.FilmPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class FilmService {

    private final FilmPersistence filmPersistence;

    @Autowired
    public FilmService(FilmPersistence filmPersistence) {
        this.filmPersistence = filmPersistence;
    }

    public Stream<Film> read(String title) {
        return this.filmPersistence.readByTitle(title);
    }

    public Film updateReviews(String title, List<Review> reviewList) {
        List<Film> films = this.filmPersistence.readAll()
                .filter(film1 -> film1.getTitle().equals(title))
                .toList();
        if (films.isEmpty())
            throw new NotFoundException("Film title : " + title);
        Film film = films.get(0);
        film.setReviews(reviewList);
        return this.filmPersistence.update(film);
    }

    public Double findRatingAverageByDirectorDni(String dni) {
        return this.filmPersistence
                .findFilmsByDirectorDni(dni)
                .flatMap(film -> film.getReviews().stream())
                        .mapToDouble(Review::getRating)
                        .average()
                        .orElse(0.0);
    }
}
