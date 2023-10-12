package es.upm.miw.apaw_practice.domain.models.film;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Film {

    private String filmId;
    private String title;
    private String synopsis;
    private LocalDate releaseDate;
    private List<Genre> genres;
    private List<Review> reviews;
    private Director director;

    public Film() {
        this.genres = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public Film(String filmId, String title, String synopsis, Director director) {
        this.filmId = filmId;
        this.title = title;
        this.synopsis = synopsis;
        this.director = director;
    }


    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Genre> getGenres() {
        return this.genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmId='" + filmId + '\'' +
                ", title='" + title + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", releaseDate=" + releaseDate +
                ", genres=" + genres +
                ", reviews=" + reviews +
                ", director=" + director +
                '}';
    }
}
