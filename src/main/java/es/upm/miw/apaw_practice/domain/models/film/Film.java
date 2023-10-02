package es.upm.miw.apaw_practice.domain.models.film;

import java.time.LocalDate;

public class Film {

    private String filmId;
    private String name;
    private String synopsis;
    private LocalDate releaseDate;

    public Film() {}

    public Film(String filmId, String name, String synopsis) {
        this.filmId = filmId;
        this.name = name;
        this.synopsis = synopsis;
    }


    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Film{" +
                "filmId='" + filmId + '\'' +
                ", name='" + name + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
