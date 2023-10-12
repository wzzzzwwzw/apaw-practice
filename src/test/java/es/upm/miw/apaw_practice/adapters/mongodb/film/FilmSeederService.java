package es.upm.miw.apaw_practice.adapters.mongodb.film;

import es.upm.miw.apaw_practice.adapters.mongodb.film.daos.DirectorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.film.daos.FilmRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.film.daos.GenreRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.film.entities.DirectorEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.film.entities.FilmEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.film.entities.GenreEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.film.entities.ReviewEntity;
import es.upm.miw.apaw_practice.domain.models.film.Director;
import es.upm.miw.apaw_practice.domain.models.film.Genre;
import es.upm.miw.apaw_practice.domain.models.film.Review;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class FilmSeederService {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private DirectorRepository directorRepository;
    @Autowired
    private GenreRepository genreRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Film Initial Load -----------");
        GenreEntity[] genres = {
                new GenreEntity(new Genre("Action", "Associated with particular types of spectacle", "Absolute")),
                new GenreEntity(new Genre("Romance", "Characterized by an emphasis on passion with romantic love", "Surrealist")),
                new GenreEntity(new Genre("Comedy", "Defined by events that are primarily intended to make the audience laugh", "Underground")),
                new GenreEntity(new Genre("Drama", "Focused on emotions and defined by conflict", "Film noir")),
                new GenreEntity(new Genre("Horror", "Films that seek to elicit fear or disgust in the audience for entertainment purposes", "Realist"))
        };
        this.genreRepository.saveAll(Arrays.asList(genres));
        DirectorEntity[] directors = {
                new DirectorEntity(new Director("05645800X", "George", "Shaw", LocalDate.of(1976, 8, 6))),
                new DirectorEntity(new Director("12258468Y", "Isabel", "Perez", LocalDate.of(1995, 11, 2))),
                new DirectorEntity(new Director("75128762Z", "Brian", "Miles", LocalDate.of(1982, 2, 15)))
        };
        this.directorRepository.saveAll(Arrays.asList(directors));
        ReviewEntity[] reviews = {
                new ReviewEntity(new Review(9, "Comment 1", true)),
                new ReviewEntity(new Review(7, "Comment 2", true)),
                new ReviewEntity(new Review(8, "Comment 3", true)),
                new ReviewEntity(new Review(10, "Comment 4", true)),
                new ReviewEntity(new Review(4, "Comment 5", false)),
                new ReviewEntity(new Review(5, "Comment 6", false)),
                new ReviewEntity(new Review(8, "Comment 7", true))
        };
        FilmEntity[] films = {
                new FilmEntity("Face/Off", "Synopsis 1", Arrays.asList(genres[0], genres[2]),
                        directors[0], Arrays.asList(reviews[0], reviews[1], reviews[2])),
                new FilmEntity("Face/Off", "Synopsis 2", Arrays.asList(genres[4]),
                        directors[1], Arrays.asList(reviews[3])),
                new FilmEntity("Gladiator", "Synopsis 3", Arrays.asList(genres[1], genres[3]),
                        directors[2], Arrays.asList(reviews[4], reviews[5], reviews[6]))
        };
        this.filmRepository.saveAll(Arrays.asList(films));
    }

    public void deleteAll() {
        this.filmRepository.deleteAll();
        this.directorRepository.deleteAll();
        this.genreRepository.deleteAll();
    }
}
