package es.upm.miw.apaw_practice.domain.services.film;

import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.film.Film;
import es.upm.miw.apaw_practice.domain.models.film.Genre;
import es.upm.miw.apaw_practice.domain.models.film.Review;
import es.upm.miw.apaw_practice.domain.persistence_ports.film.FilmPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.film.GenrePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class FilmService {

    private final FilmPersistence filmPersistence;
    private final GenrePersistence genrePersistence;

    @Autowired
    public FilmService(FilmPersistence filmPersistence, GenrePersistence genrePersistence) {
        this.filmPersistence = filmPersistence;
        this.genrePersistence = genrePersistence;
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

    public Stream<String> findCommentsWithTrueRecommendationByGenreStyle(String style) {
        List<String> genreList = this.genrePersistence.findGenreNamesByGenreStyle(style);
        if (genreList.isEmpty()) {
            throw new NotFoundException("No genres found with " + style + " style");
        }
        return this.filmPersistence.readAll()
                .filter(film -> film.getGenres().stream()
                        .map(Genre::getName)
                        .anyMatch(genreList::contains))
                .flatMap(film -> film.getReviews().stream())
                .filter(Review::getRecommendation)
                .map(Review::getComment);
    }
}
